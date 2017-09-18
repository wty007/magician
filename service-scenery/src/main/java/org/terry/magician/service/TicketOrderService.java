package org.terry.magician.service;

import org.terry.magician.BaseOrderService;
import org.terry.magician.BaseService;
import org.terry.magician.domain.OrderStatusEnum;
import org.terry.magician.domain.TicketOrder;
import org.terry.magician.domain.TicketOrderVisitor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * @author Terry
 */
public interface TicketOrderService extends BaseOrderService<TicketOrder> {
    void updateVisitors(String orderId, List<TicketOrderVisitor> visitors);
}
