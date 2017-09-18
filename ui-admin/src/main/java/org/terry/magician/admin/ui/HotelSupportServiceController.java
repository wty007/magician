package org.terry.magician.admin.ui;

import org.terry.magician.common.util.JsonService;
import org.terry.magician.domain.HotelSupportService;
import org.terry.magician.rpc.hystrix.HystrixHotelSupportServiceClient;
import org.terry.magician.rpc.hystrix.HystrixSupportServiceCategoryServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author Terry
 */
@Controller
@RequestMapping("/hotel/support/service")
public class HotelSupportServiceController {

    @Autowired
    HystrixHotelSupportServiceClient hystrixHotelSupportServiceClient;

    @Autowired
    HystrixSupportServiceCategoryServiceClient hystrixSupportServiceCategoryServiceClient;

    @Autowired
    JsonService jsonService;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public void save(@RequestParam("hotelId") String hotelId, @RequestParam("serviceIds") List<String> serviceIds) {
        hystrixHotelSupportServiceClient.save(hotelId, serviceIds);
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    @ResponseBody
    public List<HotelSupportService> get(@RequestParam("hotelId") String hotelId) {
        return hystrixHotelSupportServiceClient.getById(hotelId);
    }

}
