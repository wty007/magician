package org.terry.magician.controller;

import org.terry.magician.common.service.TicketOrderServiceDefinition;
import org.terry.magician.common.util.IdService;
import org.terry.magician.common.util.JsonService;
import org.terry.magician.common.util.OrderSnUtils;
import org.terry.magician.constant.ServiceConstants;
import org.terry.magician.domain.*;
import org.terry.magician.service.TicketOrderService;
import org.terry.magician.service.TicketService;
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
@RequestMapping(ServiceConstants.SCENERY_SERVICE_PATH_TICKET_ORDER)
public class TicketOrderController implements TicketOrderServiceDefinition {

    @Autowired
    private JsonService jsonService;
    @Autowired
    private IdService idService;

    @Autowired
    private TicketOrderService ticketOrderService;

    @Autowired
    private TicketService ticketService;

    @Override
    public Boolean updateVisitors(@RequestParam("orderId") String orderId, @RequestParam("visitorsJson") String visitorsJson) {
        List<TicketOrderVisitor> visitors = jsonService.parseArray(visitorsJson, TicketOrderVisitor.class);

        ticketOrderService.updateVisitors(orderId, visitors);

        return true;
    }

    @Override
    public TicketOrder getBySn(@RequestParam("sn") String sn) {
        return ticketOrderService.getBySn(sn);
    }

    @Override
    public List<TicketOrder> findByMemberIdAndStatues(@RequestParam("memberId") String memberId,
                                                      @RequestParam("statues") Integer[] statues) {
        List<OrderStatusEnum> statusEnumList = new ArrayList<OrderStatusEnum>();
        for (Integer status : statues) {
            final OrderStatusEnum statusEnum = OrderStatusEnum.getById(status);
            if (statusEnum != null) {
                statusEnumList.add(statusEnum);
            }
        }
        return ticketOrderService.findByMemberIdAndStatues(memberId, statusEnumList);
    }

    @Override
    public TicketOrder getById(@RequestParam("id") String id) {
        return ticketOrderService.getById(id);
    }

    @Override
    public TicketOrder save(@RequestParam("dtoJson") String dtoJson) {
        TicketOrder order = jsonService.parseObject(dtoJson, TicketOrder.class);
        ticketOrderService.save(order);
        return order;
    }

    @Override
    public PageImplWrapper<TicketOrder> findByMemberId(@RequestParam String memberId, @RequestParam Integer page, @RequestParam Integer size) {
        PageRequest pageRequest = new PageRequest(page, size);
        return new PageImplWrapper<TicketOrder>(ticketOrderService.findByMemberId(memberId, pageRequest));
    }

    @Override
    public PageImplWrapper<TicketOrder> findPageByMemberId(
            @RequestParam("memberId") String memberId,
            @RequestParam("page") Integer page, @RequestParam("size") Integer size) {
        return new PageImplWrapper<TicketOrder>(ticketOrderService.findPageByMemberId(memberId, page, size));
    }

    @Override
    public PageImplWrapper<TicketOrder> findPageByMemberIdAndStatues(
            @RequestParam("memberId") String memberId, @RequestParam("statues") Integer[] statues,
            @RequestParam("page") Integer page, @RequestParam("size") Integer size) {
        List<OrderStatusEnum> statusEnumList = new ArrayList<OrderStatusEnum>();
        for (Integer status : statues) {
            final OrderStatusEnum statusEnum = OrderStatusEnum.getById(status);
            if (statusEnum != null) {
                statusEnumList.add(statusEnum);
            }
        }
        return new PageImplWrapper<TicketOrder>(ticketOrderService.findPageByMemberIdAndStatues(memberId, statusEnumList, page, size));
    }

    @Override
    public TicketOrder createByTicketIdAndMemberId(@RequestParam("ticketId") String ticketId, @RequestParam("memberId") String memberId) {

        TicketOrder ticketOrder = new TicketOrder();

        ticketOrder.setId(idService.newOne());
        ticketOrder.setSn(OrderSnUtils.createTicketOrderSn());

        ticketOrder.setTicketId(ticketId);
        Ticket ticket = ticketService.getById(ticketId);
        ticketOrder.setSceneryId(ticket.getSceneryId());

        ticketOrder.setCreateTime(new Date());
        ticketOrder.setStatus(OrderStatusEnum.CREATED.getId());
        ticketOrder.setMemberId(memberId);

        ticketOrderService.save(ticketOrder);

        return ticketOrder;
    }
}
