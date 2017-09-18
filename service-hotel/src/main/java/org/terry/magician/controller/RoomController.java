package org.terry.magician.controller;

import org.terry.magician.common.service.RoomServiceDefinition;
import org.terry.magician.common.util.JsonService;
import org.terry.magician.constant.PageConstants;
import org.terry.magician.constant.ServiceConstants;
import org.terry.magician.domain.PageImplWrapper;
import org.terry.magician.domain.Room;
import org.terry.magician.service.RoomService;
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
@RequestMapping(ServiceConstants.HOTEL_SERVICE_PATH_ROOM)
public class RoomController implements RoomServiceDefinition {

    @Autowired
    RoomService ticketService;

    @Autowired
    JsonService jsonService;

    @Override
    public List<Room> getByHotelId(@RequestParam("hotelId") String hotelId) {
        return ticketService.getByHotelId(hotelId);
    }

    @Override
    public PageImplWrapper<Room> getPage(
            @RequestParam(value = "page", required = false, defaultValue = PageConstants.DEFAULT_PAGE_NUMBER) Integer page,
            @RequestParam(value = "size", required = false, defaultValue = PageConstants.DEFAULT_PAGE_SIZE) Integer size,
            @RequestParam(value = "sort", required = false, defaultValue = "") List<String> sorts) {
        return new PageImplWrapper<Room>(ticketService.getPage(page, size, sorts));
    }

    @Override
    public List<Room> getList() {
        return ticketService.getList();
    }

    @Override
    public Boolean deleteById(@RequestParam("id") String id) {
        ticketService.delete(id);
        return Boolean.TRUE;
    }

    @Override
    public Room getById(@RequestParam("id") String id) {
        return ticketService.getById(id);
    }

    @Override
    public Room save(@RequestParam("dtoJson") String dtoJson) {
        Room ticket = jsonService.parseObject(dtoJson, Room.class);
        return ticketService.save(ticket);
    }

}

