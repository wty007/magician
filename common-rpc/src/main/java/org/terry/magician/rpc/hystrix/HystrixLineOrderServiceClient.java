package org.terry.magician.rpc.hystrix;

import org.terry.magician.domain.Insurance;
import org.terry.magician.domain.LineOrder;
import org.terry.magician.domain.PageImplWrapper;
import org.terry.magician.rpc.LineOrderServiceClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Terry
 */
@Service
public class HystrixLineOrderServiceClient implements LineOrderServiceClient {

    @Autowired
    private LineOrderServiceClient lineOrderServiceClient;

    @Override
    @HystrixCommand(fallbackMethod = "getBySnFallBackCall")
    public LineOrder getBySn(String sn) {
        return lineOrderServiceClient.getBySn(sn);
    }

    public LineOrder getBySnFallBackCall(String sn) {
        return null;
    }

    @Override
    @HystrixCommand(fallbackMethod = "findByMemberIdAndStatuesFallBackCall")
    public List<LineOrder> findByMemberIdAndStatues(String memberId, Integer[] statues) {
        return lineOrderServiceClient.findByMemberIdAndStatues(memberId, statues);
    }

    public List<LineOrder> findByMemberIdAndStatuesFallBackCall(String memberId, Integer[] statues) {
        return null;
    }

    @Override
    @HystrixCommand(fallbackMethod = "findPageByMemberIdStatuesFallBackCall")
    public PageImplWrapper<LineOrder> findPageByMemberIdAndStatues(String memberId, Integer[] statues, Integer page, Integer size) {
        return lineOrderServiceClient.findPageByMemberIdAndStatues(memberId, statues, page, size);
    }

    public PageImplWrapper<LineOrder> findPageByMemberIdStatuesFallBackCall(String memberId, Integer[] statues, Integer page, Integer size) {
        return null;
    }

    @Override
    @HystrixCommand(fallbackMethod = "findPageByMemberIdFallBackCall")
    public PageImplWrapper<LineOrder> findPageByMemberId(String memberId, Integer page, Integer size) {
        return lineOrderServiceClient.findPageByMemberId(memberId, page, size);
    }

    public PageImplWrapper<LineOrder> findPageByMemberIdFallBackCall(String memberId, Integer page, Integer size) {
        return null;
    }

    @Override
    @HystrixCommand(fallbackMethod = "updateInsurancesFallBackCall")
    public Boolean updateInsurances(String orderId, String insuranceIds) {
        return lineOrderServiceClient.updateInsurances(orderId, insuranceIds);
    }

    @Override
    @HystrixCommand(fallbackMethod = "getInsuranceByIdFallBackCall")
    public Insurance getInsuranceById(String insuranceId) {
        return lineOrderServiceClient.getInsuranceById(insuranceId);
    }

    public Insurance getInsuranceByIdFallBackCall(String insuranceId) {
        return null;
    }

    public Boolean updateInsurancesFallBackCall(String orderId, String insuranceIds) {
        return Boolean.FALSE;
    }

    @Override
    @HystrixCommand(fallbackMethod = "updateVisitorsFallBackCall")
    public Boolean updateVisitors(String orderId, String visitorsJson) {
        return lineOrderServiceClient.updateVisitors(orderId, visitorsJson);
    }

    public Boolean updateVisitorsFallBackCall(String orderId, String visitorsJson) {
        return Boolean.FALSE;
    }

    @Override
    @HystrixCommand(fallbackMethod = "saveFallBackCall")
    public LineOrder save(String dtoJson) {
        return lineOrderServiceClient.save(dtoJson);
    }

    public LineOrder saveFallBackCall(String dtoJson) {
        return null;
    }

    @Override
    @HystrixCommand(fallbackMethod = "getByIdFallBackCall")
    public LineOrder getById(String id) {
        return lineOrderServiceClient.getById(id);
    }

    public LineOrder getByIdFallBackCall(String id) {
        return null;
    }

    @Override
    @HystrixCommand(fallbackMethod = "findByMemberIdFallBackCall")
    public PageImplWrapper<LineOrder> findByMemberId(String memberId, Integer page, Integer size) {
        return lineOrderServiceClient.findByMemberId(memberId, page, size);
    }

    public PageImplWrapper<LineOrder> findByMemberIdFallBackCall(String memberId, Integer page, Integer size) {
        return lineOrderServiceClient.findByMemberId(memberId, page, size);
    }

    @Override
    @HystrixCommand(fallbackMethod = "createByLineIdFallBackCall")
    public LineOrder createByLineIdAndMemberId(String lineId, String memberId) {
        return lineOrderServiceClient.createByLineIdAndMemberId(lineId, memberId);
    }

    public LineOrder createByLineIdFallBackCall(String lineId, String memberId) {
        return null;
    }
}

