package org.terry.magician.service.impl;

import org.terry.magician.BaseOrderRepository;
import org.terry.magician.BaseOrderServiceImpl;
import org.terry.magician.domain.RoomOrder;
import org.terry.magician.repository.RoomOrderRepository;
import org.terry.magician.service.RoomOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Terry
 */
@Service
public class RoomOrderServiceImpl extends BaseOrderServiceImpl<RoomOrder> implements RoomOrderService {

    @Autowired
    RoomOrderRepository roomOrderRepository;

    @Override
    protected BaseOrderRepository<RoomOrder> getRepository() {
        return roomOrderRepository;
    }

}
