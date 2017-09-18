package org.terry.magician.rpc.hystrix;

import org.terry.magician.domain.Hotel;
import org.terry.magician.domain.PageImplWrapper;
import org.terry.magician.rpc.HotelServiceClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Terry
 */
@Service
public class HystrixHotelServiceClient implements HotelServiceClient {

    @Autowired
    private HotelServiceClient hotelServiceClient;

    @Override
    @HystrixCommand(fallbackMethod = "searchFallBackCall")
    public PageImplWrapper<Hotel> search(
            String city, String checkInTimeString, String leaveTimeString, String keyword, Integer page, Integer size) {
        return hotelServiceClient.search(city, checkInTimeString, leaveTimeString, keyword, page, size);
    }

    public PageImplWrapper<Hotel> searchFallBackCall(
            String city, String checkInTimeString, String leaveTimeString, String keyword, Integer page, Integer size) {
        return null;
    }

    @Override
    @HystrixCommand(fallbackMethod = "getRecommendListFallBackCall")
    public List<Hotel> getRecommendList() {
        return hotelServiceClient.getRecommendList();
    }

    public List<Hotel> getRecommendListFallBackCall() {
        return null;
    }

    @Override
    @HystrixCommand(fallbackMethod = "deleteFallBackCall")
    public Hotel deleteById(String id) {
        return hotelServiceClient.deleteById(id);
    }

    @Override
    @HystrixCommand(fallbackMethod = "saveFallBackCall")
    public Hotel save(String dtoJson) {
        return hotelServiceClient.save(dtoJson);
    }

    @Override
    @HystrixCommand(fallbackMethod = "getByIdFallBackCall")
    public Hotel getById(String id) {
        return hotelServiceClient.getById(id);
    }

    @Override
    @HystrixCommand(fallbackMethod = "getPageFallBackCall")
    public PageImplWrapper<Hotel> getPage(Integer page, Integer size, List<String> sort) {
        return hotelServiceClient.getPage(page, size, sort);
    }

    @Override
    @HystrixCommand(fallbackMethod = "getListFallBackCall")
    public List<Hotel> getList() {
        return hotelServiceClient.getList();
    }

    public Hotel deleteFallBackCall(String id) {
        return null;
    }


    public Hotel getByIdFallBackCall(String id) {
        return null;
    }

    public Hotel saveFallBackCall(String name) {
        return null;
    }

    public PageImplWrapper<Hotel> getPageFallBackCall(Integer page, Integer size, List<String> sort) {
        return null;
    }

    public List<Hotel> getListFallBackCall() {
        return null;
    }
}

