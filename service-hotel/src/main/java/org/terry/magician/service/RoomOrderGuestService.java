package org.terry.magician.service;

import org.terry.magician.BaseService;
import org.terry.magician.domain.RoomOrderGuest;

import java.util.List;

/**
 * @author Terry
 */
public interface RoomOrderGuestService extends BaseService<RoomOrderGuest> {
    List<RoomOrderGuest> findByRoomOrderId(String orderId);
}
