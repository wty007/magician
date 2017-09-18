package org.terry.magician.repository;

import org.terry.magician.domain.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Terry
 */
@Repository
public interface TicketRepository extends JpaRepository<Ticket, String> {
    List<Ticket> findBySceneryId(String sceneryId);
}
