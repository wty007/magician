package org.terry.magician.service.impl;

import org.terry.magician.BaseServiceImpl;
import org.terry.magician.domain.Ticket;
import org.terry.magician.repository.TicketRepository;
import org.terry.magician.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Terry
 */
@Service
public class TicketServiceImpl extends BaseServiceImpl<Ticket> implements TicketService {

    @Autowired
    TicketRepository ticketRepository;

    @Override
    protected JpaRepository<Ticket, String> getRepository() {
        return ticketRepository;
    }

    @Override
    public List<Ticket> getBySceneryId(String sceneryId) {
        return ticketRepository.findBySceneryId(sceneryId);
    }

}
