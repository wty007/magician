package org.terry.magician.controller;

import org.terry.magician.common.service.HotelSupportServiceDefinition;
import org.terry.magician.common.util.IdService;
import org.terry.magician.constant.ServiceConstants;
import org.terry.magician.domain.Hotel;
import org.terry.magician.domain.HotelSupportService;
import org.terry.magician.repository.HotelRepository;
import org.terry.magician.repository.HotelSupportServiceRepository;
import org.terry.magician.repository.SupportServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Terry
 */
@RestController
@RequestMapping(ServiceConstants.PATH_HOTEL_SUPPORT_SERVICE)
public class HotelSupportServiceController implements HotelSupportServiceDefinition {

    @Autowired
    IdService idService;

    @Autowired
    HotelSupportServiceRepository hotelSupportServiceRepository;

    @Autowired
    HotelRepository hotelRepository;

    @Autowired
    SupportServiceRepository supportServiceRepository;

    @Override
    public void save(@RequestParam("hotelId") String hotelId, @RequestParam("serviceIds") List<String> serviceIds) {

        hotelSupportServiceRepository.delete(hotelSupportServiceRepository.findByHotelId(hotelId));

        Hotel hotel = hotelRepository.findOne(hotelId);
        for (String serviceId : serviceIds) {
            HotelSupportService hotelSupportService = new HotelSupportService();
            hotelSupportService.setId(idService.newOne());
            hotelSupportService.setHotel(hotel);
            hotelSupportService.setService(supportServiceRepository.findOne(serviceId));
            hotelSupportServiceRepository.save(hotelSupportService);
        }

    }

    @Override
    public List<HotelSupportService> getById(@RequestParam("hotelId") String hotelId) {
        return hotelSupportServiceRepository.findByHotelId(hotelId);
    }
}
