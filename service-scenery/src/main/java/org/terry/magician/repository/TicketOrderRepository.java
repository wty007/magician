package org.terry.magician.repository;

import org.terry.magician.BaseOrderRepository;
import org.terry.magician.domain.TicketOrder;
import org.springframework.stereotype.Repository;

/**
 * @author Terry
 */
@Repository
public interface TicketOrderRepository extends BaseOrderRepository<TicketOrder> {
}
