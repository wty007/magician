package org.terry.magician.service.impl;

import org.terry.magician.BaseServiceImpl;
import org.terry.magician.domain.RoomOrderGuest;
import org.terry.magician.repository.RoomOrderGuestRepository;
import org.terry.magician.service.RoomOrderGuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Terry
 */
@Service
public class RoomGuestServiceImpl extends BaseServiceImpl<RoomOrderGuest> implements RoomOrderGuestService {

    @Autowired
    RoomOrderGuestRepository roomOrderGuestRepository;

    @Override
    protected JpaRepository<RoomOrderGuest, String> getRepository() {
        return roomOrderGuestRepository;
    }

    @Override
    public List<RoomOrderGuest> findByRoomOrderId(String orderId) {
        return roomOrderGuestRepository.findByRoomOrderId(orderId);
    }
}
