package org.terry.magician.rpc.hystrix;

import com.google.common.collect.Lists;
import org.terry.magician.domain.PageImplWrapper;
import org.terry.magician.domain.Room;
import org.terry.magician.rpc.RoomServiceClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Terry
 */
@Service
public class HystrixRoomServiceClient implements RoomServiceClient {

    @Autowired
    private RoomServiceClient roomServiceClient;

    @Override
    @HystrixCommand(fallbackMethod = "getByHotelIdFallBackCall")
    public List<Room> getByHotelId(String hotelId) {
        return roomServiceClient.getByHotelId(hotelId);
    }

    public List<Room> getByHotelIdFallBackCall(String hotelId) {
        return null;
    }

    @Override
    @HystrixCommand(fallbackMethod = "deleteFallBackCall")
    public Boolean deleteById(String id) {
        return roomServiceClient.deleteById(id);
    }

    @Override
    @HystrixCommand(fallbackMethod = "saveFallBackCall")
    public Room save(String dtoJson) {
        return roomServiceClient.save(dtoJson);
    }

    @Override
    @HystrixCommand(fallbackMethod = "getByIdFallBackCall")
    public Room getById(String id) {
        return roomServiceClient.getById(id);
    }

    @Override
    @HystrixCommand(fallbackMethod = "getPageFallBackCall")
    public PageImplWrapper<Room> getPage(Integer page, Integer size, List<String> sort) {
        return roomServiceClient.getPage(page, size, sort);
    }

    @Override
    @HystrixCommand(fallbackMethod = "getListFallBackCall")
    public List<Room> getList() {
        return roomServiceClient.getList();
    }

    public Boolean deleteFallBackCall(String id) {
        return false;
    }

    public Room getByIdFallBackCall(String id) {
        return null;
    }

    public Room saveFallBackCall(String name) {
        return null;
    }

    public PageImplWrapper<Room> getPageFallBackCall(Integer page, Integer size, List<String> sort) {
        return new PageImplWrapper<Room>(Lists.<Room>newArrayList());
    }

    public List<Room> getListFallBackCall() {
        return Lists.<Room>newArrayList();
    }
}

