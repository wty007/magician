package org.terry.magician.rpc.hystrix;

import org.terry.magician.domain.PageImplWrapper;
import org.terry.magician.domain.RoomOrder;
import org.terry.magician.rpc.RoomOrderServiceClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Terry
 */
@Service
public class HystrixRoomOrderServiceClient implements RoomOrderServiceClient {

    @Autowired
    private RoomOrderServiceClient roomOrderServiceClient;

    @Override
    @HystrixCommand(fallbackMethod = "getBySnFallBackCall")
    public RoomOrder getBySn(String sn) {
        return roomOrderServiceClient.getBySn(sn);
    }

    public RoomOrder getBySnFallBackCall(String sn) {
        return null;
    }

    @Override
    @HystrixCommand(fallbackMethod = "findPageByMemberIdFallBackCall")
    public PageImplWrapper<RoomOrder> findPageByMemberId(String memberId, Integer pageNo, Integer pageSize) {
        return roomOrderServiceClient.findByMemberId(memberId, pageNo, pageSize);
    }

    public PageImplWrapper<RoomOrder> findPageByMemberIdFallBackCall(String memberId, Integer pageNo, Integer pageSize) {
        return null;
    }

    @Override
    @HystrixCommand(fallbackMethod = "findByMemberIdAndStatuesFallBackCall")
    public List<RoomOrder> findByMemberIdAndStatues(String memberId, Integer[] statues) {
        return roomOrderServiceClient.findByMemberIdAndStatues(memberId, statues);
    }

    public List<RoomOrder> findByMemberIdAndStatuesFallBackCall(String memberId, Integer[] statues) {
        return null;
    }

    @Override
    @HystrixCommand(fallbackMethod = "findPageByMemberIdAndStatuesFallBackCall")
    public PageImplWrapper<RoomOrder> findPageByMemberIdAndStatues(String memberId, Integer[] statues, Integer pageNo, Integer pageSize) {
        return roomOrderServiceClient.findPageByMemberIdAndStatues(memberId, statues, pageNo, pageSize);
    }

    public PageImplWrapper<RoomOrder> findPageByMemberIdAndStatuesFallBackCall(
            String memberId, Integer[] statues, Integer pageNo, Integer pageSize) {
        return null;
    }

    @Override
    @HystrixCommand(fallbackMethod = "updateGuestsFallBackCall")
    public Boolean updateGuests(String orderId, String guestsJson) {
        return roomOrderServiceClient.updateGuests(orderId, guestsJson);
    }

    public Boolean updateGuestsFallBackCall(String orderId, String guestsJson) {
        return null;
    }

    @Override
    @HystrixCommand(fallbackMethod = "findByMemberIdFallBackCall")
    public PageImplWrapper<RoomOrder> findByMemberId(
            String memberId,
            Integer page,
            Integer size) {
        return roomOrderServiceClient.findByMemberId(memberId, page, size);
    }

    public PageImplWrapper<RoomOrder> findByMemberIdFallBackCall(
            String memberId,
            Integer page,
            Integer size) {
        return roomOrderServiceClient.findByMemberId(memberId, page, size);
    }

    @Override
    @HystrixCommand(fallbackMethod = "createByRoomIdAndMemberIdFallBackCall")
    public RoomOrder createByRoomIdAndMemberId(String roomId, String memberId) {
        return roomOrderServiceClient.createByRoomIdAndMemberId(roomId, memberId);
    }

    public RoomOrder createByRoomIdAndMemberIdFallBackCall(
            String roomId, String memberId) {
        return null;
    }

    @Override
    @HystrixCommand(fallbackMethod = "getByIdFallBackCall")
    public RoomOrder getById(String id) {
        return roomOrderServiceClient.getById(id);
    }

    public RoomOrder getByIdFallBackCall(String id) {
        return null;
    }

    @Override
    @HystrixCommand(fallbackMethod = "saveFallBackCall")
    public RoomOrder save(String dtoJson) {
        return roomOrderServiceClient.save(dtoJson);
    }

    public RoomOrder saveFallBackCall(String dtoJson) {
        return null;
    }
}

