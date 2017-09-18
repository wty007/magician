package org.terry.magician.repository;

import org.terry.magician.domain.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Terry
 */
@Repository
public interface RoomRepository extends JpaRepository<Room, String> {
    List<Room> getByHotelId(String hotelId);
}
