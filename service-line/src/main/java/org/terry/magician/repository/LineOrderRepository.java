package org.terry.magician.repository;

import org.terry.magician.BaseOrderRepository;
import org.terry.magician.domain.LineOrder;
import org.springframework.stereotype.Repository;

/**
 * @author Terry
 */
@Repository
public interface LineOrderRepository extends BaseOrderRepository<LineOrder> {
}
