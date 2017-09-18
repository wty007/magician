package org.terry.magician.rpc.hystrix;

import com.google.common.collect.Lists;
import org.terry.magician.domain.HotelSupportService;
import org.terry.magician.rpc.HotelSupportServiceClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Terry
 */
@Service
public class HystrixHotelSupportServiceClient implements HotelSupportServiceClient {

    @Autowired
    private HotelSupportServiceClient hotelSupportServiceClient;

    @Override
    @HystrixCommand(fallbackMethod = "saveFallBackCall")
    public void save(String hotelId, List<String> serviceIds) {
        hotelSupportServiceClient.save(hotelId, serviceIds);
    }

    public void saveFallBackCall(String hotelId, List<String> serviceIds) {
        System.out.println("saveFallBackCall");
    }

    @Override
    @HystrixCommand(fallbackMethod = "getByIdFallBackCall")
    public List<HotelSupportService> getById(String hotelId) {
        return hotelSupportServiceClient.getById(hotelId);
    }

    public List<HotelSupportService> getByIdFallBackCall(String hotelId) {
        System.out.println("getByIdFallBackCall");
        return Lists.newArrayList();
    }


    //    @Override
//    @HystrixCommand(fallbackMethod = "deleteFallBackCall")
//    public SupportService deleteById(String id) {
//        return supportServiceServiceClient.deleteById(id);
//    }
//
//    @Override
//    @HystrixCommand(fallbackMethod = "saveFallBackCall")
//    public SupportService save(String dtoJson) {
//        return supportServiceServiceClient.save(dtoJson);
//    }
//
//    @Override
//    @HystrixCommand(fallbackMethod = "getByIdFallBackCall")
//    public SupportService getById(String id) {
//        return supportServiceServiceClient.getById(id);
//    }
//
//    @Override
//    @HystrixCommand(fallbackMethod = "getListFallBackCall")
//    public PageImplWrapper<SupportService> getPage(Integer getPage, Integer size) {
//        return supportServiceServiceClient.getPage(getPage, size);
//    }
//
//    public SupportService deleteFallBackCall(String id) {
//        SupportService supportService = new SupportService();
//        supportService.setName("FAILED HOTEL SERVICE CALL! - FALLING BACK" + id);
//        return supportService;
//    }
//
//    public SupportService getByIdFallBackCall(String id) {
//        SupportService supportService = new SupportService();
//        supportService.setName("FAILED HOTEL SERVICE CALL! - FALLING BACK" + id);
//        return supportService;
//    }
//
//    public SupportService saveFallBackCall(String name) {
//        SupportService supportService = new SupportService();
//        supportService.setName("FAILED HOTEL SERVICE CALL! - FALLING BACK" + name);
//        return supportService;
//    }
//
//    public PageImplWrapper<SupportService> getListFallBackCall(Integer getPage, Integer size) {
//        return new PageImplWrapper<SupportService>(Lists.<SupportService>newArrayList());
//    }
}

