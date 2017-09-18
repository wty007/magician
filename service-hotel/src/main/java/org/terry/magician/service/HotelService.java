package org.terry.magician.service;

import org.terry.magician.BaseService;
import org.terry.magician.domain.Hotel;
import org.springframework.data.domain.Page;

/**
 * @author Terry
 */
public interface HotelService extends BaseService<Hotel> {
    Page<Hotel> findPageByNameLike(String keyword, Integer page, Integer size);
}
