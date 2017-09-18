package org.terry.magician.controller;

import org.terry.magician.common.service.RoomOrderServiceDefinition;
import org.terry.magician.common.util.IdService;
import org.terry.magician.common.util.JsonService;
import org.terry.magician.common.util.OrderSnUtils;
import org.terry.magician.constant.ServiceConstants;
import org.terry.magician.domain.*;
import org.terry.magician.service.RoomOrderGuestService;
import org.terry.magician.service.RoomOrderService;
import org.terry.magician.service.RoomService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Terry
 */
@RefreshScope
@Api
@RestController
@RequestMapping(ServiceConstants.HOTEL_SERVICE_PATH_ROOM_ORDER)
public class RoomOrderController implements RoomOrderServiceDefinition {

    @Autowired
    private JsonService jsonService;
    @Autowired
    private IdService idService;

    @Autowired
    private RoomOrderService roomOrderService;

    @Autowired
    private RoomOrderGuestService roomOrderGuestService;

    @Autowired
    private RoomService roomService;

    @Override
    public RoomOrder getBySn(@RequestParam("sn") String sn) {
        return roomOrderService.getBySn(sn);
    }

    @Override
    public Boolean updateGuests(@RequestParam("orderId") String orderId, @RequestParam("guestsJson") String guestsJson) {
        List<RoomOrderGuest> guests = jsonService.parseArray(guestsJson, RoomOrderGuest.class);

        roomOrderGuestService.delete(roomOrderGuestService.findByRoomOrderId(orderId));

        int sort = 1;
        for (RoomOrderGuest guest : guests) {
            guest.setRoomOrderId(orderId);
            guest.setSort(sort++);
            roomOrderGuestService.save(guest);
        }

        return Boolean.TRUE;
    }

    @Override
    public PageImplWrapper<RoomOrder> findPageByMemberId(
            @RequestParam("memberId") String memberId,
            @RequestParam("page") Integer page, @RequestParam("size") Integer size) {
        return new PageImplWrapper<RoomOrder>(roomOrderService.findPageByMemberId(memberId, page, size));
    }

    @Override
    public PageImplWrapper<RoomOrder> findPageByMemberIdAndStatues(
            @RequestParam("memberId") String memberId, @RequestParam("statues") Integer[] statues,
            @RequestParam("page") Integer page, @RequestParam("size") Integer size) {
        List<OrderStatusEnum> statusEnumList = new ArrayList<OrderStatusEnum>();
        for (Integer status : statues) {
            final OrderStatusEnum statusEnum = OrderStatusEnum.getById(status);
            if (statusEnum != null) {
                statusEnumList.add(statusEnum);
            }
        }
        return new PageImplWrapper<RoomOrder>(roomOrderService.findPageByMemberIdAndStatues(memberId, statusEnumList, page, size));
    }

    @Override
    public List<RoomOrder> findByMemberIdAndStatues(@RequestParam("memberId") String memberId,
                                                    @RequestParam("statues") Integer[] statues) {
        List<OrderStatusEnum> statusEnumList = new ArrayList<OrderStatusEnum>();
        for (Integer status : statues) {
            final OrderStatusEnum statusEnum = OrderStatusEnum.getById(status);
            if (statusEnum != null) {
                statusEnumList.add(statusEnum);
            }
        }
        return roomOrderService.findByMemberIdAndStatues(memberId, statusEnumList);
    }

    @Override
    public RoomOrder getById(@RequestParam("id") String id) {
        return roomOrderService.getById(id);
    }

    @Override
    public RoomOrder save(@RequestParam("dtoJson") String dtoJson) {
        RoomOrder order = jsonService.parseObject(dtoJson, RoomOrder.class);
        roomOrderService.save(order);
        return order;
    }

    @Override
    public PageImplWrapper<RoomOrder> findByMemberId(@RequestParam String memberId, @RequestParam Integer page, @RequestParam Integer size) {
        PageRequest pageRequest = new PageRequest(page, size);
        return new PageImplWrapper<RoomOrder>(roomOrderService.findByMemberId(memberId, pageRequest));
    }

    @Override
    public RoomOrder createByRoomIdAndMemberId(@RequestParam("roomId") String roomId,
                                               @RequestParam("memberId") String memberId) {

        RoomOrder roomOrder = new RoomOrder();

        roomOrder.setId(idService.newOne());
        roomOrder.setSn(OrderSnUtils.createRoomOrderSn());

        roomOrder.setRoomId(roomId);
        Room room = roomService.getById(roomId);
        roomOrder.setRoomId(room.getId());
        roomOrder.setHotelId(room.getHotelId());

        roomOrder.setCreateTime(new Date());
        roomOrder.setStatus(OrderStatusEnum.CREATED.getId());
        roomOrder.setMemberId(memberId);

        roomOrderService.save(roomOrder);

        return roomOrder;
    }
}
