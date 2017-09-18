package org.terry.magician.common.service;

import org.terry.magician.domain.HotelSupportService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author Terry
 */
public interface HotelSupportServiceDefinition {

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    void save(@RequestParam("hotelId") String hotelId, @RequestParam("serviceIds") List<String> serviceIds);

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    List<HotelSupportService> getById(@RequestParam("hotelId") String hotelId);
}
