package org.terry.magician.common.service;

import org.terry.magician.constant.PageConstants;
import org.terry.magician.domain.PageImplWrapper;
import org.terry.magician.domain.Room;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author Terry
 */
public interface RoomServiceDefinition {

    @RequestMapping(value = "/page", method = RequestMethod.GET)
    PageImplWrapper<Room> getPage(
            @RequestParam(value = "page", required = false, defaultValue = PageConstants.DEFAULT_PAGE_NUMBER) Integer page,
            @RequestParam(value = "size", required = false, defaultValue = PageConstants.DEFAULT_PAGE_SIZE) Integer size,
            @RequestParam(value = "sort", required = false, defaultValue = "") List<String> sort);

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    List<Room> getList();

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    Room save(@RequestParam("dtoJson") String dtoJson);

    @RequestMapping(value = "/del", method = RequestMethod.POST)
    Boolean deleteById(@RequestParam("id") String id);

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    Room getById(@RequestParam("id") String id);

    @RequestMapping(value = "/getByHotelId", method = RequestMethod.GET)
    List<Room> getByHotelId(@RequestParam("hotelId") String hotelId);
}
