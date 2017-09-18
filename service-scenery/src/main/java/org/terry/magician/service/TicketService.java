package org.terry.magician.service;

import org.terry.magician.BaseService;
import org.terry.magician.domain.Ticket;
import org.terry.magician.domain.TicketOrder;

import java.util.List;

/**
 * @author Terry
 */
public interface TicketService extends BaseService<Ticket> {
    List<Ticket> getBySceneryId(String sceneryId);
}
