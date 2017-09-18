package org.terry.magician.common.service;

import org.terry.magician.constant.PageConstants;
import org.terry.magician.domain.PageImplWrapper;
import org.terry.magician.domain.Ticket;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author Terry
 */
public interface TicketServiceDefinition {

    @RequestMapping(value = "/page", method = RequestMethod.GET)
    PageImplWrapper<Ticket> getPage(
            @RequestParam(value = "page", required = false, defaultValue = PageConstants.DEFAULT_PAGE_NUMBER) Integer page,
            @RequestParam(value = "size", required = false, defaultValue = PageConstants.DEFAULT_PAGE_SIZE) Integer size,
            @RequestParam(value = "sort", required = false, defaultValue = "") List<String> sort);

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    List<Ticket> getList();

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    Ticket save(@RequestParam("dtoJson") String dtoJson);

    @RequestMapping(value = "/del", method = RequestMethod.POST)
    Boolean deleteById(@RequestParam("id") String id);

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    Ticket getById(@RequestParam("id") String id);

    @RequestMapping(value = "/getListBySceneryId", method = RequestMethod.GET)
    List<Ticket> getListBySceneryId(@RequestParam("sceneryId") String sceneryId);

}
