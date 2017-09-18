package org.terry.magician.rpc.hystrix;

import org.terry.magician.domain.Insurance;
import org.terry.magician.domain.PageImplWrapper;
import org.terry.magician.domain.TicketOrder;
import org.terry.magician.rpc.TicketOrderServiceClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Terry
 */
@Service
public class HystrixTicketOrderServiceClient implements TicketOrderServiceClient {

    @Autowired
    private TicketOrderServiceClient ticketOrderServiceClient;

    @Override
    @HystrixCommand(fallbackMethod = "updateVisitorsFallBackCall")
    public Boolean updateVisitors(String orderId, String visitorsJson) {
        return ticketOrderServiceClient.updateVisitors(orderId, visitorsJson);
    }

    @Override
    @HystrixCommand(fallbackMethod = "getBySnFallBackCall")
    public TicketOrder getBySn(String sn) {
        return ticketOrderServiceClient.getBySn(sn);
    }

    public TicketOrder getBySnFallBackCall(String sn) {
        return null;
    }

    @Override
    @HystrixCommand(fallbackMethod = "findByMemberIdAndStatuesFallBackCall")
    public List<TicketOrder> findByMemberIdAndStatues(String memberId, Integer[] statues) {
        return ticketOrderServiceClient.findByMemberIdAndStatues(memberId, statues);
    }

    public List<TicketOrder> findByMemberIdAndStatuesFallBackCall(String memberId, Integer[] statues) {
        return null;
    }

    @Override
    @HystrixCommand(fallbackMethod = "findPageByMemberIdAndStatuesFallBackCall")
    public PageImplWrapper<TicketOrder> findPageByMemberIdAndStatues(String memberId, Integer[] statues, Integer pageNo, Integer pageSize) {
        return ticketOrderServiceClient.findPageByMemberIdAndStatues(memberId, statues, pageNo, pageSize);
    }

    public PageImplWrapper<TicketOrder> findPageByMemberIdAndStatuesFallBackCall(String memberId, Integer[] statues, Integer pageNo, Integer pageSize) {
        return null;
    }

    @Override
    @HystrixCommand(fallbackMethod = "findPageByMemberIdFallBackCall")
    public PageImplWrapper<TicketOrder> findPageByMemberId(String memberId, Integer pageNo, Integer pageSize) {
        return ticketOrderServiceClient.findByMemberId(memberId, pageNo, pageSize);
    }

    public PageImplWrapper<TicketOrder> findPageByMemberIdFallBackCall(String memberId, Integer pageNo, Integer pageSize) {
        return null;
    }


    public TicketOrder createByTicketIdAndMemberIdFallBackCall(
            String ticketId, String memberId) {
        return null;
    }

    public Insurance getInsuranceByIdFallBackCall(String insuranceId) {
        return null;
    }

    public Boolean updateInsurancesFallBackCall(String orderId, String insuranceIds) {
        return Boolean.FALSE;
    }

    public Boolean updateVisitorsFallBackCall(String orderId, String visitorsJson) {
        return Boolean.FALSE;
    }

    @Override
    @HystrixCommand(fallbackMethod = "saveFallBackCall")
    public TicketOrder save(String dtoJson) {
        return ticketOrderServiceClient.save(dtoJson);
    }

    public TicketOrder saveFallBackCall(String dtoJson) {
        return null;
    }

    @Override
    @HystrixCommand(fallbackMethod = "getByIdFallBackCall")
    public TicketOrder getById(String id) {
        return ticketOrderServiceClient.getById(id);
    }

    public TicketOrder getByIdFallBackCall(String id) {
        return null;
    }

    @Override
    @HystrixCommand(fallbackMethod = "findByMemberIdFallBackCall")
    public PageImplWrapper<TicketOrder> findByMemberId(String memberId, Integer page, Integer size) {
        return ticketOrderServiceClient.findByMemberId(memberId, page, size);
    }

    @Override
    @HystrixCommand(fallbackMethod = "createByTicketIdFallBackCall")
    public TicketOrder createByTicketIdAndMemberId(String ticketId, String memberId) {
        return ticketOrderServiceClient.createByTicketIdAndMemberId(ticketId, memberId);
    }

    public TicketOrder createByTicketIdFallBackCall(String ticketId, String memberId) {
        return null;
    }

    public PageImplWrapper<TicketOrder> findByMemberIdFallBackCall(String memberId, Integer page, Integer size) {
        return ticketOrderServiceClient.findByMemberId(memberId, page, size);
    }
}

