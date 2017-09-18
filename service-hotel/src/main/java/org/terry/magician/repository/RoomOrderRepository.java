package org.terry.magician.repository;

import org.terry.magician.BaseOrderRepository;
import org.terry.magician.domain.RoomOrder;
import org.springframework.stereotype.Repository;

/**
 * @author Terry
 */
@Repository
public interface RoomOrderRepository extends BaseOrderRepository<RoomOrder> {
}
