package org.terry.magician.controller;

import org.terry.magician.common.service.LineOrderServiceDefinition;
import org.terry.magician.common.util.IdService;
import org.terry.magician.common.util.JsonService;
import org.terry.magician.common.util.OrderSnUtils;
import org.terry.magician.constant.ServiceConstants;
import org.terry.magician.domain.*;
import org.terry.magician.repository.InsuranceRepository;
import org.terry.magician.repository.LineOrderRepository;
import org.terry.magician.service.LineOrderService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.data.domain.PageRequest;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Terry
 */
@RefreshScope
@Api
@RestController
@RequestMapping(ServiceConstants.LINE_SERVICE_PATH_ORDER)
public class LineOrderController implements LineOrderServiceDefinition {

    @Autowired
    private LineOrderRepository lineOrderRepository;
    @Autowired
    private JsonService jsonService;
    @Autowired
    private IdService idService;
    @Autowired
    private LineOrderService lineOrderService;
    @Autowired
    private InsuranceRepository insuranceRepository;

    @Override
    public PageImplWrapper<LineOrder> findPageByMemberIdAndStatues(@RequestParam("memberId") String memberId,
                                                                   @RequestParam("status") Integer[] statues,
                                                                   @RequestParam("page") Integer page,
                                                                   @RequestParam("size") Integer size) {
        List<OrderStatusEnum> statusEnumList = new ArrayList<OrderStatusEnum>();
        for (Integer status : statues) {
            final OrderStatusEnum statusEnum = OrderStatusEnum.getById(status);
            if (statusEnum != null) {
                statusEnumList.add(statusEnum);
            }
        }
        return new PageImplWrapper<LineOrder>(lineOrderService.findPageByMemberIdAndStatues(memberId, statusEnumList, page, size));
    }

    @Override
    public List<LineOrder> findByMemberIdAndStatues(@RequestParam("memberId") String memberId,
                                                    @RequestParam("statues") Integer[] statues) {
        List<OrderStatusEnum> statusEnumList = new ArrayList<OrderStatusEnum>();
        for (Integer status : statues) {
            final OrderStatusEnum statusEnum = OrderStatusEnum.getById(status);
            if (statusEnum != null) {
                statusEnumList.add(statusEnum);
            }
        }
        return lineOrderService.findByMemberIdAndStatues(memberId, statusEnumList);
    }

    @Override
    public PageImplWrapper<LineOrder> findPageByMemberId(@RequestParam("memberId") String memberId,
                                                         @RequestParam("page") Integer page,
                                                         @RequestParam("size") Integer size) {
        return new PageImplWrapper<LineOrder>(lineOrderService.findPageByMemberId(memberId, page, size));
    }

    @Override
    public Boolean updateInsurances(
            @RequestParam("orderId") String orderId,
            @RequestParam("insuranceIds") String insuranceIds) {
        if (StringUtils.isEmpty(insuranceIds)) {
            return Boolean.TRUE;
        }

        String[] insuranceIdArray = insuranceIds.split(",");
        List<Insurance> insurances = new ArrayList<Insurance>();
        for (String insuranceId : insuranceIdArray) {
            final Insurance insurance = insuranceRepository.findOne(insuranceId);
            if (insurance == null) {
                return Boolean.FALSE;
            }

            insurances.add(insurance);
        }

        lineOrderService.updateInsurances(orderId, insurances);

        return Boolean.TRUE;
    }

    @Override
    public Insurance getInsuranceById(@RequestParam("insuranceId") String insuranceId) {
        return insuranceRepository.findOne(insuranceId);
    }

    @Override
    public Boolean updateVisitors(@RequestParam("orderId") String orderId,
                                  @RequestParam("visitorsJson") String visitorsJson) {

        List<LineOrderVisitor> visitors = jsonService.parseArray(visitorsJson, LineOrderVisitor.class);

        lineOrderService.updateVisitors(orderId, visitors);

        return true;
    }

    @Override
    public LineOrder getById(@RequestParam("id") String id) {
        return lineOrderRepository.findOne(id);
    }

    @Override
    public LineOrder getBySn(@RequestParam("sn") String sn) {
        return lineOrderRepository.findBySn(sn);
    }

    @Override
    public LineOrder save(@RequestParam("dtoJson") String dtoJson) {
        LineOrder order = jsonService.parseObject(dtoJson, LineOrder.class);
        lineOrderService.save(order);
        return order;
    }

    @Override
    public PageImplWrapper<LineOrder> findByMemberId(@RequestParam String memberId, @RequestParam Integer page, @RequestParam Integer size) {
        PageRequest pageRequest = new PageRequest(page, size);
        return new PageImplWrapper<LineOrder>(lineOrderRepository.findByMemberId(memberId, pageRequest));
    }

    @Override
    public LineOrder createByLineIdAndMemberId(@RequestParam("lineId") String lineId, @RequestParam("memberId") String memberId) {

        LineOrder lineOrder = new LineOrder();

        lineOrder.setId(idService.newOne());

        lineOrder.setSn(OrderSnUtils.createLineOrderSn());
        lineOrder.setLineId(lineId);
        lineOrder.setCreateTime(new Date());
        lineOrder.setStatus(OrderStatusEnum.CREATED.getId());
        lineOrder.setMemberId(memberId);

        lineOrderService.save(lineOrder);

        return lineOrder;
    }
}
