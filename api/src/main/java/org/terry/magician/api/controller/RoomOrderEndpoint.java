package org.terry.magician.api.controller;

import org.terry.magician.api.Constants;
import org.terry.magician.api.service.OrderPayNotifyService;
import org.terry.magician.api.service.OrderService;
import org.terry.magician.api.service.PayService;
import org.terry.magician.api.service.VoBuilderService;
import org.terry.magician.api.support.APIResult;
import org.terry.magician.api.support.ErrorCode;
import org.terry.magician.api.support.ServiceException;
import org.terry.magician.api.vo.*;
import org.terry.magician.common.util.DateUtils;
import org.terry.magician.common.util.JsonService;
import org.terry.magician.domain.*;
import org.terry.magician.rpc.hystrix.*;
import org.terry.magician.util.MemberUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * @author Terry
 */
@RestController
public class RoomOrderEndpoint {

    private static final String UTF_8_META = "<meta http-equiv=\"Content-Type\" content=\"text/html;charset=utf-8\" />";

    @Autowired
    HystrixMemberServiceClient hystrixMemberServiceClient;

    @Autowired
    HystrixRoomOrderServiceClient hystrixRoomOrderServiceClient;

    @Autowired
    VoBuilderService voBuilderService;

    @Autowired
    HystrixInsuranceServiceClient hystrixInsuranceServiceClient;

    @Autowired
    HystrixVerifyCodeServiceClient hystrixVerifyCodeServiceClient;

    @Autowired
    PayService payService;

    @Autowired
    HystrixRoomServiceClient hystrixRoomServiceClient;

    @Autowired
    OrderService orderService;

    @Autowired
    OrderPayNotifyService orderPayNotifyService;

    @Autowired
    private JsonService jsonService;

    @RequestMapping("room/order/start")
    public Object roomOrderStart(@RequestParam String roomId,
                                 @RequestParam String checkInTime,
                                 @RequestParam String leaveTime,
                                 @RequestParam(required = false, defaultValue = "") String token) {

        final Date checkInTimeDate = DateUtils.parseDate(checkInTime);
        final Date leaveTimeDate = DateUtils.parseDate(leaveTime);

        if (checkInTimeDate == null) {
            throw new ServiceException("错误的入住时间");
        }

        if (leaveTimeDate == null) {
            throw new ServiceException("错误的离店时间");
        }

        String realToken = token;
        Member member = null;

        if (StringUtils.isEmpty(token)) {
            Member guestMember = hystrixMemberServiceClient.createGuest();
            realToken = guestMember.getToken();
            member = guestMember;
        } else {
            member = getAndCheckMemberByToken(token);
        }

        Room room = hystrixRoomServiceClient.getById(roomId);

        if (room == null) {
            throw new ServiceException("不存在此房间");
        }

        RoomOrder roomOrder = hystrixRoomOrderServiceClient.createByRoomIdAndMemberId(roomId, member.getId());

        roomOrder.setCheckInTime(checkInTimeDate);
        roomOrder.setLeaveTime(leaveTimeDate);

        hystrixRoomOrderServiceClient.save(jsonService.toJson(roomOrder));

        Map<String, String> map = new HashMap<String, String>();
        map.put("orderId", roomOrder.getId());
        map.put("token", realToken);

        return APIResult.createSuccess(map);
    }

    /**
     * @param orderId
     * @param token
     * @return
     */
    @RequestMapping("room/order/info")
    public Object roomOrderInfo(@RequestParam String orderId,
                                @RequestParam String token) {

        getAndCheckMemberByToken(token);

        RoomOrder roomOrder = getAndCheckByOrderId(orderId);

        getOrderAndCheckTokenCanOperateOrder(token, orderId);

        RoomOrderInfoVO vo = voBuilderService.buildVO(roomOrder);

        return APIResult.createSuccess(vo);
    }

    private RoomOrder getAndCheckByOrderId(String orderId) {
        final RoomOrder roomOrder = hystrixRoomOrderServiceClient.getById(orderId);
        if (roomOrder == null) {
            throw new ServiceException("错误的订单ID");
        }
        return roomOrder;
    }

    private Member getAndCheckMemberByToken(String token) {
        final Member member = hystrixMemberServiceClient.getByToken(token);
        if (member == null) {
            throw new ServiceException("登陆已过期", ErrorCode.TOKEN_EXPIRED);
        }
        return member;
    }

    @RequestMapping("room/order/commit")
    public Object roomOrderCommit(
            @RequestParam String orderId, @RequestParam String token,
            @RequestParam Integer count,
            @RequestParam Integer keepTillTime,
            @RequestParam String guests,
            @RequestParam String bookingPersonRealName, @RequestParam String bookingPersonMobilePhone,
            @RequestParam(required = false, defaultValue = "") String code) {

        Member member = getAndCheckMemberByToken(token);
        RoomOrder roomOrder = getAndCheckByOrderId(orderId);

        getOrderAndCheckTokenCanOperateOrder(token, orderId);

        if (count <= 0) {
            throw new ServiceException("份数为0,无法提交");
        }

        if (MemberUtils.isGuestMember(member) && StringUtils.isEmpty(code)) {
            throw new ServiceException("未填写验证码,无法提交");
        }

        if (MemberUtils.isGuestMember(member) && isValidCode(bookingPersonMobilePhone, code)) {
            throw new ServiceException("错误的验证码", ErrorCode.TOKEN_EXPIRED);
        }

        if (!orderService.canChangeStatus(OrderStatusEnum.getById(roomOrder.getStatus()), OrderStatusEnum.UN_PAID)) {
            throw new ServiceException("错误的订单状态,无法提交");
        }

        roomOrder.setKeepTillTime(keepTillTime);
        roomOrder.setCount(count);
        roomOrder.setBookingPersonMobilePhone(bookingPersonMobilePhone);
        roomOrder.setBookingPersonRealName(bookingPersonRealName);

        String finalToken = token;

        //如果是游客用户,则查询是否存在手机号为bookingPersonMobilePhone的用户,如果有则把订单memberId设置为此用户,否则把游客用户的手机号设置为bookingPersonMobilePhone
        if (MemberUtils.isGuestMember(member)) {
            Member alreadyExistMember = hystrixMemberServiceClient.getByMobilePhone(bookingPersonMobilePhone);
            if (alreadyExistMember == null) {
                member.setMobilePhone(bookingPersonMobilePhone);
                hystrixMemberServiceClient.save(jsonService.toJson(member));
            } else {
                roomOrder.setMemberId(alreadyExistMember.getId());
                finalToken = hystrixMemberServiceClient.login(alreadyExistMember.getMobilePhone());
            }
        }

        orderService.changeStatus(roomOrder, OrderStatusEnum.getById(roomOrder.getStatus()), OrderStatusEnum.UN_PAID);

        OrderPriceVO orderPriceVO = getOrderPriceVO(token, orderId, count);
        roomOrder.setPrice(orderPriceVO.getPrice());
        hystrixRoomOrderServiceClient.save(jsonService.toJson(roomOrder));

        List<RoomOrderGuest> roomOrderGuests = new ArrayList<RoomOrderGuest>();
        List<RoomOrderGuestVO> roomOrderGuestVOs = jsonService.parseArray(guests, RoomOrderGuestVO.class);

        for (RoomOrderGuestVO vo : roomOrderGuestVOs) {
            final RoomOrderGuest roomOrderVisitor = new RoomOrderGuest();
            BeanUtils.copyProperties(vo, roomOrderVisitor);
            roomOrderGuests.add(roomOrderVisitor);
        }
        hystrixRoomOrderServiceClient.updateGuests(orderId, jsonService.toJson(roomOrderGuests));

        Map<String, String> map = new HashMap<String, String>();
        map.put("orderId", orderId);
        map.put("token", finalToken);

        return APIResult.createSuccess(map);
    }

    private boolean isValidCode(String bookingPersonMobilePhone, String code) {
        return !hystrixVerifyCodeServiceClient.verify(bookingPersonMobilePhone, code, Constants.TYPE_VERIFY_CODE_ALL);
    }

    private Date getDate(String date) {
        Date result = DateUtils.parseDate(date);
        if (result == null) {
            throw new ServiceException("错误日期", ErrorCode.COMMON);
        }
        return result;
    }

    @RequestMapping("room/order/cancel")
    public Object roomOrderCancel(@RequestParam String token,
                                  @RequestParam String orderId,
                                  @RequestParam(required = false, defaultValue = "") String reason) {

        RoomOrder roomOrder = getOrderAndCheckTokenCanOperateOrder(token, orderId);

        orderService.changeStatus(roomOrder, OrderStatusEnum.getById(roomOrder.getStatus()), OrderStatusEnum.CANCEL);
        roomOrder.setCancelReason(reason);

        hystrixRoomOrderServiceClient.save(jsonService.toJson(roomOrder));

        return APIResult.createSuccess(Boolean.TRUE);
    }

    @RequestMapping("room/order/calculatePrice")
    public Object roomOrderCalculatePrice(@RequestParam String token,
                                          @RequestParam String orderId,
                                          @RequestParam Integer count) {
        return APIResult.createSuccess(getOrderPriceVO(token, orderId, count));
    }

    private OrderPriceVO getOrderPriceVO(String token, String orderId, Integer count) {
        Double price = 0D;
        Double marketPrice = 0D;

        RoomOrder roomOrder = getOrderAndCheckTokenCanOperateOrder(token, orderId);
        Integer days = DateUtils.getDistanceOfTwoDate(roomOrder.getLeaveTime(), roomOrder.getCheckInTime());

        String roomId = roomOrder.getRoomId();

        Room room = hystrixRoomServiceClient.getById(roomId);
        Double personPrice = room.getPrice();
        Double marketPersonPrice = room.getMarketPrice();

        price += personPrice * count * days;
        marketPrice += marketPersonPrice * count * days;

        OrderPriceVO orderPriceVO = new OrderPriceVO();
        orderPriceVO.setPrice(price);
        orderPriceVO.setMarketPrice(marketPrice);
        return orderPriceVO;
    }

    private RoomOrder getOrderAndCheckTokenCanOperateOrder(String token, String orderId) {
        RoomOrder roomOrder = getAndCheckByOrderId(orderId);
        Member member = getAndCheckMemberByToken(token);
        String memberId = roomOrder.getMemberId();
        if (!memberId.equals(member.getId())) {
            throw new ServiceException("不是您的订单,无法操作");
        }
        return roomOrder;
    }

    @RequestMapping("room/order/detail")
    public Object roomOrderDetail(@RequestParam String token, @RequestParam String orderId) {

        RoomOrder roomOrder = getOrderAndCheckTokenCanOperateOrder(token, orderId);

        RoomOrderDetailVO vo = voBuilderService.buildOrderDetail(roomOrder);

        return APIResult.createSuccess(vo);
    }

    @RequestMapping("room/order/pay")
    public Object roomOrderPay(@RequestParam("orderId") String orderId, @RequestParam("token") String token) {

        RoomOrder roomOrder = getOrderAndCheckTokenCanOperateOrder(token, orderId);

//        Double price = roomOrder.getPrice();
        Double price = 0.1D;

        String content = payService.getPayString(roomOrder.getSn(), price);

        return APIResult.createSuccess(UTF_8_META + content);
    }

    @RequestMapping("room/order/list")
    public Object roomOrderList(@RequestParam String token,
                                @RequestParam(required = false, defaultValue = "" + OrderService.ORDER_STATUS_ALL) Integer status,
                                @RequestParam(required = false, defaultValue = "0") Integer pageNo,
                                @RequestParam(required = false, defaultValue = "5") Integer pageSize) {
        Member member = getAndCheckMemberByToken(token);

        PageImplWrapper<RoomOrder> pageImplWrapper = null;

        if (status == OrderService.ORDER_STATUS_ALL) {
            pageImplWrapper = hystrixRoomOrderServiceClient.findPageByMemberId(
                    member.getId(), pageNo, pageSize);
        } else {
            Integer[] realStates = orderService.getRealOrderStatues(status);
            pageImplWrapper = hystrixRoomOrderServiceClient.findPageByMemberIdAndStatues(
                    member.getId(), realStates, pageNo, pageSize);
        }

        List<RoomOrder> roomOrders = pageImplWrapper.getContent();

        List<RoomOrderDetailVO> vos = new ArrayList<RoomOrderDetailVO>();

        for (RoomOrder roomOrder : roomOrders) {
            vos.add(voBuilderService.buildOrderDetail(roomOrder));
        }

        return APIResult.createSuccess(new PageVO<RoomOrderDetailVO>(vos, !pageImplWrapper.isLast()));
    }
}
