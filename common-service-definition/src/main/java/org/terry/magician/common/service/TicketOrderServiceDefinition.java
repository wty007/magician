package org.terry.magician.common.service;

import org.terry.magician.domain.PageImplWrapper;
import org.terry.magician.domain.TicketOrder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author Terry
 */
public interface TicketOrderServiceDefinition {

    @RequestMapping(value = "/findByMemberId", method = RequestMethod.GET)
    PageImplWrapper<TicketOrder> findByMemberId(@RequestParam("memberId") String memberId, @RequestParam("page") Integer page, @RequestParam("size") Integer size);

    @RequestMapping(value = "/createByTicketIdAndMemberId", method = RequestMethod.GET)
    TicketOrder createByTicketIdAndMemberId(@RequestParam("ticketId") String ticketId, @RequestParam("memberId") String memberId);

    @RequestMapping(value = "/getById", method = RequestMethod.GET)
    TicketOrder getById(@RequestParam("id") String id);

    @RequestMapping(value = "/getBySn", method = RequestMethod.GET)
    TicketOrder getBySn(@RequestParam("sn") String sn);

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    TicketOrder save(@RequestParam("dtoJson") String dtoJson);

    @RequestMapping(value = "/updateVisitors", method = RequestMethod.POST)
    Boolean updateVisitors(@RequestParam("orderId") String orderId, @RequestParam("visitorsJson") String visitorsJson);

    @RequestMapping(value = "/findPageByMemberId", method = RequestMethod.GET)
    PageImplWrapper<TicketOrder> findPageByMemberId(@RequestParam("memberId") String memberId,
                                                    @RequestParam("pageNo") Integer pageNo,
                                                    @RequestParam("pageSize") Integer pageSize);

    @RequestMapping(value = "/findPageByMemberIdAndStatues", method = RequestMethod.GET)
    PageImplWrapper<TicketOrder> findPageByMemberIdAndStatues(@RequestParam("memberId") String memberId,
                                                              @RequestParam("statues") Integer[] statues,
                                                              @RequestParam("page") Integer page,
                                                              @RequestParam("size") Integer size);

    @RequestMapping(value = "/findByMemberIdAndStatues", method = RequestMethod.GET)
    List<TicketOrder> findByMemberIdAndStatues(@RequestParam("memberId") String memberId,
                                               @RequestParam("statues") Integer[] statues);
}
