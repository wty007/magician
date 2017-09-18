package org.terry.magician.service.impl;

import org.terry.magician.BaseOrderRepository;
import org.terry.magician.BaseOrderServiceImpl;
import org.terry.magician.domain.TicketOrder;
import org.terry.magician.domain.TicketOrderVisitor;
import org.terry.magician.domain.util.EntityUtils;
import org.terry.magician.repository.TicketOrderRepository;
import org.terry.magician.repository.TicketOrderVisitorRepository;
import org.terry.magician.service.TicketOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Terry
 */
@Service
public class TicketOrderServiceImpl extends BaseOrderServiceImpl<TicketOrder> implements TicketOrderService {

    @Autowired
    TicketOrderRepository ticketOrderRepository;

    @Autowired
    TicketOrderVisitorRepository ticketOrderVisitorRepository;

    @Override
    protected BaseOrderRepository<TicketOrder> getRepository() {
        return ticketOrderRepository;
    }

    @Override
    public void updateVisitors(String orderId, List<TicketOrderVisitor> visitors) {
        ticketOrderVisitorRepository.delete(ticketOrderVisitorRepository.findByOrderId(orderId));

        for (TicketOrderVisitor visitor : visitors) {
            visitor.setOrderId(orderId);
            EntityUtils.preSave(visitor);
            ticketOrderVisitorRepository.save(visitor);
        }
    }
}
