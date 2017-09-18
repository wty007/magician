package org.terry.magician.service;

import org.terry.magician.BaseService;
import org.terry.magician.domain.Room;

import java.util.List;

/**
 * @author Terry
 */
public interface RoomService extends BaseService<Room> {
    List<Room> getByHotelId(String hotelId);
}
