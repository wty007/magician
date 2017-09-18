package org.terry.magician.service.impl;

import org.terry.magician.BaseOrderRepository;
import org.terry.magician.BaseOrderServiceImpl;
import org.terry.magician.domain.Insurance;
import org.terry.magician.domain.LineOrder;
import org.terry.magician.domain.LineOrderInsurance;
import org.terry.magician.domain.LineOrderVisitor;
import org.terry.magician.domain.util.EntityUtils;
import org.terry.magician.repository.LineOrderInsuranceRepository;
import org.terry.magician.repository.LineOrderRepository;
import org.terry.magician.repository.LineOrderVisitorRepository;
import org.terry.magician.service.LineOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author Terry
 */
@Service
@Transactional
public class LineOrderServiceImpl extends BaseOrderServiceImpl<LineOrder> implements LineOrderService {

    @Autowired
    LineOrderVisitorRepository lineOrderVisitorRepository;

    @Autowired
    LineOrderInsuranceRepository lineOrderInsuranceRepository;

    @Autowired
    LineOrderRepository lineOrderRepository;

    @Override
    public void updateVisitors(String orderId, List<LineOrderVisitor> visitors) {
        lineOrderVisitorRepository.delete(lineOrderVisitorRepository.findByOrderId(orderId));

        for (LineOrderVisitor visitor : visitors) {
            visitor.setOrderId(orderId);
            EntityUtils.preSave(visitor);
            lineOrderVisitorRepository.save(visitor);
        }
    }

    @Override
    public void updateInsurances(String orderId, List<Insurance> insurances) {
        final List<LineOrderInsurance> alreadyExist = lineOrderInsuranceRepository.findByLineOrderId(orderId);
        if (!CollectionUtils.isEmpty(alreadyExist)) {
            lineOrderInsuranceRepository.delete(alreadyExist);
        }

        for (Insurance insurance : insurances) {
            LineOrderInsurance lineOrderInsurance = new LineOrderInsurance();
            lineOrderInsurance.setLineOrderId(orderId);
            lineOrderInsurance.setInsuranceId(insurance.getId());
            lineOrderInsurance.setPrice(insurance.getPrice());

            EntityUtils.preSave(lineOrderInsurance);
            lineOrderInsuranceRepository.save(lineOrderInsurance);
        }
    }

    @Override
    protected BaseOrderRepository<LineOrder> getRepository() {
        return lineOrderRepository;
    }
}
