package org.terry.magician.service;

import org.terry.magician.BaseOrderService;
import org.terry.magician.BaseService;
import org.terry.magician.domain.Insurance;
import org.terry.magician.domain.LineOrder;
import org.terry.magician.domain.LineOrderVisitor;
import org.terry.magician.domain.OrderStatusEnum;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @author Terry
 */
public interface LineOrderService extends BaseOrderService<LineOrder> {
    void updateVisitors(String orderId, List<LineOrderVisitor> visitors);

    void updateInsurances(String orderId, List<Insurance> insurances);

}
