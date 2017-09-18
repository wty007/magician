package org.terry.magician.service.impl;

import org.terry.magician.BaseServiceImpl;
import org.terry.magician.domain.Room;
import org.terry.magician.repository.RoomRepository;
import org.terry.magician.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Terry
 */
@Service
public class RoomServiceImpl extends BaseServiceImpl<Room> implements RoomService {

    @Autowired
    RoomRepository roomRepository;

    @Override
    protected JpaRepository<Room, String> getRepository() {
        return roomRepository;
    }

    @Override
    public List<Room> getByHotelId(String hotelId) {
        return roomRepository.getByHotelId(hotelId);
    }
}
