package org.terry.magician.common.service;

import org.terry.magician.domain.Insurance;
import org.terry.magician.domain.LineOrder;
import org.terry.magician.domain.PageImplWrapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author Terry
 */
public interface LineOrderServiceDefinition {

    @RequestMapping(value = "/findByMemberId", method = RequestMethod.GET)
    PageImplWrapper<LineOrder> findByMemberId(@RequestParam("memberId") String memberId, @RequestParam("page") Integer page, @RequestParam("size") Integer size);

    @RequestMapping(value = "/createByLineId", method = RequestMethod.GET)
    LineOrder createByLineIdAndMemberId(@RequestParam("lineId") String lineId, @RequestParam("memberId") String memberId);

    @RequestMapping(value = "/getById", method = RequestMethod.GET)
    LineOrder getById(@RequestParam("id") String id);

    @RequestMapping(value = "/getBySn", method = RequestMethod.GET)
    LineOrder getBySn(@RequestParam("sn") String sn);

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    LineOrder save(@RequestParam("dtoJson") String dtoJson);

    @RequestMapping(value = "/updateVisitors", method = RequestMethod.POST)
    Boolean updateVisitors(@RequestParam("orderId") String orderId, @RequestParam("visitorsJson") String visitorsJson);

    @RequestMapping(value = "/updateInsurances", method = RequestMethod.POST)
    Boolean updateInsurances(@RequestParam("orderId") String orderId, @RequestParam("insuranceIds") String insuranceIds);

    @RequestMapping(value = "/getInsuranceById", method = RequestMethod.GET)
    Insurance getInsuranceById(@RequestParam("insuranceId") String insuranceId);

    @RequestMapping(value = "/findPageByMemberIdAndStatues", method = RequestMethod.GET)
    PageImplWrapper<LineOrder> findPageByMemberIdAndStatues(@RequestParam("memberId") String memberId,
                                                            @RequestParam("status") Integer[] status,
                                                            @RequestParam("page") Integer page,
                                                            @RequestParam("size") Integer size);

    @RequestMapping(value = "/findPageByMemberId", method = RequestMethod.GET)
    PageImplWrapper<LineOrder> findPageByMemberId(@RequestParam("memberId") String memberId,
                                                  @RequestParam("page") Integer page,
                                                  @RequestParam("size") Integer size);

    @RequestMapping(value = "/findByMemberIdAndStatues", method = RequestMethod.GET)
    List<LineOrder> findByMemberIdAndStatues(@RequestParam("memberId") String memberId,
                                             @RequestParam("statues") Integer[] statues);
}
