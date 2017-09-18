package org.terry.magician.controller;

import org.terry.magician.common.service.TicketServiceDefinition;
import org.terry.magician.common.util.JsonService;
import org.terry.magician.constant.PageConstants;
import org.terry.magician.constant.ServiceConstants;
import org.terry.magician.domain.PageImplWrapper;
import org.terry.magician.domain.Ticket;
import org.terry.magician.service.TicketService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Terry
 */
@RefreshScope
@Api
@RestController
@RequestMapping(ServiceConstants.SCENERY_SERVICE_PATH_TICKET)
public class TicketController implements TicketServiceDefinition {

    @Autowired
    TicketService ticketService;

    @Autowired
    JsonService jsonService;

    @Override
    public List<Ticket> getListBySceneryId(@RequestParam("sceneryId") String sceneryId) {
        return ticketService.getBySceneryId(sceneryId);
    }

    @Override
    public PageImplWrapper<Ticket> getPage(
            @RequestParam(value = "page", required = false, defaultValue = PageConstants.DEFAULT_PAGE_NUMBER) Integer page,
            @RequestParam(value = "size", required = false, defaultValue = PageConstants.DEFAULT_PAGE_SIZE) Integer size,
            @RequestParam(value = "sort", required = false, defaultValue = "") List<String> sorts) {
        return new PageImplWrapper<Ticket>(ticketService.getPage(page, size, sorts));
    }

    @Override
    public List<Ticket> getList() {
        return ticketService.getList();
    }

    @Override
    public Boolean deleteById(@RequestParam("id") String id) {
        ticketService.delete(id);
        return Boolean.TRUE;
    }

    @Override
    public Ticket getById(@RequestParam("id") String id) {
        return ticketService.getById(id);
    }

    @Override
    public Ticket save(@RequestParam("dtoJson") String dtoJson) {
        Ticket ticket = jsonService.parseObject(dtoJson, Ticket.class);
        return ticketService.save(ticket);
    }

}

