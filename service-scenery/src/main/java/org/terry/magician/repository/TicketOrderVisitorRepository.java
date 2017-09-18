package org.terry.magician.repository;

import org.terry.magician.domain.TicketOrderVisitor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Terry
 */
@Repository
public interface TicketOrderVisitorRepository extends JpaRepository<TicketOrderVisitor, String> {
    List<TicketOrderVisitor> findByOrderId(String lineOrderId);
}
