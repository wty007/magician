package org.terry.magician.repository;

import org.terry.magician.domain.RoomOrderGuest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Terry
 */
@Repository
public interface RoomOrderGuestRepository extends JpaRepository<RoomOrderGuest, String> {
    List<RoomOrderGuest> findByRoomOrderId(String orderId);
}
