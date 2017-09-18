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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author Terry
 */
@RestController
public class LineOrderEndpoint {

    private static final String UTF_8_META = "<meta http-equiv=\"Content-Type\" content=\"text/html;charset=utf-8\" />";

    @Autowired
    HystrixMemberServiceClient hystrixMemberServiceClient;

    @Autowired
    HystrixLineOrderServiceClient hystrixLineOrderServiceClient;

    @Autowired
    VoBuilderService voBuilderService;
    @Autowired
    HystrixInsuranceServiceClient hystrixInsuranceServiceClient;
    @Autowired
    HystrixVerifyCodeServiceClient hystrixVerifyCodeServiceClient;
    @Autowired
    PayService payService;
    @Autowired
    HystrixLineServiceClient hystrixLineServiceClient;
    @Autowired
    OrderService orderService;
    @Autowired
    OrderPayNotifyService orderPayNotifyService;
    @Autowired
    private JsonService jsonService;

    @RequestMapping("line/order/start")
    public Object lineDetail(@RequestParam String lineId,
                             @RequestParam(required = false, defaultValue = "") String token) {

        String realToken = token;
        Member member = null;

        if (StringUtils.isEmpty(token)) {
            Member guestMember = hystrixMemberServiceClient.createGuest();
            realToken = guestMember.getToken();
            member = guestMember;
        } else {
            member = getAndCheckMemberByToken(token);
        }

        LineOrder lineOrder = hystrixLineOrderServiceClient.createByLineIdAndMemberId(lineId, member.getId());

        Map<String, String> map = new HashMap<String, String>();
        map.put("orderId", lineOrder.getId());
        map.put("token", realToken);

        return APIResult.createSuccess(map);
    }

    /**
     * @param orderId
     * @param token
     * @return
     */
    @RequestMapping("line/order/info")
    public Object lineOrderInfo(@RequestParam String orderId,
                                @RequestParam String token) {

        getAndCheckMemberByToken(token);

        LineOrder lineOrder = getAndCheckByOrderId(orderId);

        getAndCheckTokenCanOperateOrder(token, orderId);

        List<Insurance> insurances = hystrixInsuranceServiceClient.getList();
        LineOrderInfoVO vo = voBuilderService.buildVO(lineOrder, insurances);

        return APIResult.createSuccess(vo);
    }

    private LineOrder getAndCheckByOrderId(String orderId) {
        final LineOrder lineOrder = hystrixLineOrderServiceClient.getById(orderId);
        if (lineOrder == null) {
            throw new ServiceException("错误的线路订单ID");
        }
        return lineOrder;
    }

    private Member getAndCheckMemberByToken(String token) {
        final Member member = hystrixMemberServiceClient.getByToken(token);
        if (member == null) {
            throw new ServiceException("登陆已过期", ErrorCode.TOKEN_EXPIRED);
        }
        return member;
    }

    @RequestMapping("line/order/commit")
    public Object lineOrderCommit(
            @RequestParam String orderId, @RequestParam String token,
            @RequestParam String startingTime,
            @RequestParam(required = false, defaultValue = "") String insuranceIds,
            @RequestParam Integer adultCount, @RequestParam Integer childCount,
            @RequestParam String bookingPersonRealName, @RequestParam String bookingPersonMobilePhone,
            @RequestParam String bookingPersonEmail,
            @RequestParam(required = false, defaultValue = "") String bookingPersonRemark,
            @RequestParam(required = false, defaultValue = "") String code,
            @RequestParam(required = false, defaultValue = "") String visitors) {

        Member member = getAndCheckMemberByToken(token);
        LineOrder lineOrder = getAndCheckByOrderId(orderId);

        getAndCheckTokenCanOperateOrder(token, orderId);

        if ((adultCount + childCount) <= 0) {
            throw new ServiceException("人数为0,无法提交");
        }

        if (MemberUtils.isGuestMember(member) && StringUtils.isEmpty(code)) {
            throw new ServiceException("未填写验证码,无法提交");
        }

        if (MemberUtils.isGuestMember(member) && isValidCode(bookingPersonMobilePhone, code)) {
            throw new ServiceException("错误的验证码", ErrorCode.TOKEN_EXPIRED);
        }

        if (!orderService.canChangeStatus(OrderStatusEnum.getById(lineOrder.getStatus()), OrderStatusEnum.UN_PAID)) {
            throw new ServiceException("错误的订单状态,无法提交");
        }

        lineOrder.setStartDate(getDate(startingTime));
        lineOrder.setAdultCount(adultCount);
        lineOrder.setChildCount(childCount);
        lineOrder.setBookingPersonEmail(bookingPersonEmail);
        lineOrder.setBookingPersonMobilePhone(bookingPersonMobilePhone);
        lineOrder.setBookingPersonRealName(bookingPersonRealName);
        lineOrder.setBookingPersonRemark(bookingPersonRemark);

        String finalToken = token;

        //如果是游客用户,则查询是否存在手机号为bookingPersonMobilePhone的用户,如果有则把订单memberId设置为此用户,否则把游客用户的手机号设置为bookingPersonMobilePhone
        if (MemberUtils.isGuestMember(member)) {
            Member alreadyExistMember = hystrixMemberServiceClient.getByMobilePhone(bookingPersonMobilePhone);
            if (alreadyExistMember == null) {
                member.setMobilePhone(bookingPersonMobilePhone);
                hystrixMemberServiceClient.save(jsonService.toJson(member));
            } else {
                lineOrder.setMemberId(alreadyExistMember.getId());
                finalToken = hystrixMemberServiceClient.login(alreadyExistMember.getMobilePhone());
            }
        }

        orderService.changeStatus(lineOrder, OrderStatusEnum.getById(lineOrder.getStatus()), OrderStatusEnum.UN_PAID);

        OrderPriceVO orderPriceVO = getOrderPriceVO(token, orderId, insuranceIds, adultCount, childCount);
        lineOrder.setPrice(orderPriceVO.getPrice());
        hystrixLineOrderServiceClient.save(jsonService.toJson(lineOrder));

        List<LineOrderVisitor> lineOrderVisitorList = new ArrayList<LineOrderVisitor>();
        List<LineOrderVisitorVO> visitorVOList = jsonService.parseArray(visitors, LineOrderVisitorVO.class);
        for (LineOrderVisitorVO vo : visitorVOList) {
            final LineOrderVisitor lineOrderVisitor = new LineOrderVisitor();
            BeanUtils.copyProperties(vo, lineOrderVisitor);
            lineOrderVisitorList.add(lineOrderVisitor);
        }

        hystrixLineOrderServiceClient.updateVisitors(orderId, jsonService.toJson(lineOrderVisitorList));

        if (isValidInsuranceIds(insuranceIds)) {
            hystrixLineOrderServiceClient.updateInsurances(orderId, insuranceIds);
        }

        Map<String, String> map = new HashMap<String, String>();
        map.put("orderId", orderId);
        map.put("token", finalToken);

        return APIResult.createSuccess(map);
    }

    private boolean isValidCode(String bookingPersonMobilePhone, String code) {
        return !hystrixVerifyCodeServiceClient.verify(bookingPersonMobilePhone, code, Constants.TYPE_VERIFY_CODE_ALL);
    }

    private boolean isValidInsuranceIds(String insuranceIds) {
        return !StringUtils.isEmpty(insuranceIds);
    }

    private Date getDate(String date) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        throw new ServiceException("错误日期", ErrorCode.COMMON);
    }

    @RequestMapping("line/order/cancel")
    public Object lineOrderCancel(@RequestParam String token,
                                  @RequestParam String orderId,
                                  @RequestParam(required = false, defaultValue = "") String reason) {

        LineOrder lineOrder = getAndCheckTokenCanOperateOrder(token, orderId);

        orderService.changeStatus(lineOrder, OrderStatusEnum.getById(lineOrder.getStatus()), OrderStatusEnum.CANCEL);
        lineOrder.setCancelReason(reason);

        hystrixLineOrderServiceClient.save(jsonService.toJson(lineOrder));

        return APIResult.createSuccess(Boolean.TRUE);
    }

    /**
     * String token 用户token
     * String orderId 订单ID
     * String insuranceIds 选中的保险ID,多个使用逗号分隔
     * Integer adultCount 成人数量
     * Integer childCount 儿童数量
     *
     * @return
     */
    @RequestMapping("line/order/calculatePrice")
    public Object lineOrderCalculatePrice(@RequestParam String token,
                                          @RequestParam String orderId,
                                          @RequestParam(required = false) String insuranceIds,
                                          @RequestParam Integer adultCount,
                                          @RequestParam Integer childCount) {

        OrderPriceVO orderPriceVO = getOrderPriceVO(token, orderId, insuranceIds, adultCount, childCount);

        return APIResult.createSuccess(orderPriceVO);
    }

    private OrderPriceVO getOrderPriceVO(String token, String orderId, String insuranceIds,
                                         Integer adultCount, Integer childCount) {
        Double price = 0D;
        Double marketPrice = 0D;

        LineOrder lineOrder = getAndCheckTokenCanOperateOrder(token, orderId);

        String lineId = lineOrder.getLineId();

        Line line = hystrixLineServiceClient.getById(lineId);
        Double personPrice = line.getStartingPrice();
        Double marketPersonPrice = line.getMarketPrice();

        price += personPrice * (adultCount + childCount);
        marketPrice += marketPersonPrice * (adultCount + childCount);

        if (isValidInsuranceIds(insuranceIds)) {

            for (String insuranceId : insuranceIds.split(",")) {
                Insurance insurance = hystrixLineOrderServiceClient.getInsuranceById(insuranceId);
                if (insurance != null) {
                    price += insurance.getPrice() * (adultCount + childCount);
                    marketPrice += insurance.getPrice() * (adultCount + childCount);
                }
            }
        }

        OrderPriceVO orderPriceVO = new OrderPriceVO();
        orderPriceVO.setPrice(price);
        orderPriceVO.setMarketPrice(marketPrice);
        return orderPriceVO;
    }

    private LineOrder getAndCheckTokenCanOperateOrder(String token, String orderId) {
        LineOrder lineOrder = getAndCheckByOrderId(orderId);
        Member member = getAndCheckMemberByToken(token);
        String memberId = lineOrder.getMemberId();
        if (!memberId.equals(member.getId())) {
            throw new ServiceException("不是您的订单,无法操作");
        }
        return lineOrder;
    }

    @RequestMapping("line/order/detail")
    public Object lineOrderDetail(@RequestParam String token, @RequestParam String orderId) {
        LineOrder lineOrder = getAndCheckTokenCanOperateOrder(token, orderId);
        return APIResult.createSuccess(voBuilderService.buildOrderDetail(lineOrder));
    }

    @RequestMapping("line/order/list")
    public Object lineOrderList(@RequestParam String token,
                                @RequestParam(required = false, defaultValue = "" + OrderService.ORDER_STATUS_ALL) Integer status,
                                @RequestParam(required = false, defaultValue = "0") Integer pageNo,
                                @RequestParam(required = false, defaultValue = "5") Integer pageSize) {
        Member member = getAndCheckMemberByToken(token);

        PageImplWrapper<LineOrder> pageImplWrapper = null;

        if (status == OrderService.ORDER_STATUS_ALL) {
            pageImplWrapper = hystrixLineOrderServiceClient.findPageByMemberId(
                    member.getId(), pageNo, pageSize);
        } else {
            Integer[] realStates = orderService.getRealOrderStatues(status);
            pageImplWrapper = hystrixLineOrderServiceClient.findPageByMemberIdAndStatues(
                    member.getId(), realStates, pageNo, pageSize);
        }

        List<LineOrder> lineOrders = pageImplWrapper.getContent();

        List<LineOrderDetailVO> vos = new ArrayList<LineOrderDetailVO>();

        for (LineOrder lineOrder : lineOrders) {
            vos.add(voBuilderService.buildOrderDetail(lineOrder));
        }

        return APIResult.createSuccess(new PageVO<LineOrderDetailVO>(vos, !pageImplWrapper.isLast()));
    }

    @RequestMapping("line/order/pay")
    public Object lineOrderPay(@RequestParam("orderId") String orderId, @RequestParam("token") String token) {

        LineOrder lineOrder = getAndCheckTokenCanOperateOrder(token, orderId);

//        Double price = lineOrder.getPrice();

        Double price = 0.1D;

        String content = payService.getPayString(lineOrder.getSn(), price);

        System.out.println(content);

        //todo
        return APIResult.createSuccess(UTF_8_META + content);
    }

    @Deprecated
    @RequestMapping("line/order/pay/success")
    public Object lineOrderPaySuccess(@RequestParam("orderId") String orderId, @RequestParam("token") String token) {
        LineOrder lineOrder = getAndCheckTokenCanOperateOrder(token, orderId);

        orderPayNotifyService.success(lineOrder.getSn(), PayTypeEnum.QUICK);

        return APIResult.createSuccess();
    }

}
