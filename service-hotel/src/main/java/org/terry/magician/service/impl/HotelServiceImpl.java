package org.terry.magician.service.impl;

import org.terry.magician.BaseServiceImpl;
import org.terry.magician.domain.Hotel;
import org.terry.magician.repository.HotelRepository;
import org.terry.magician.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * @author Terry
 */
@Service
public class HotelServiceImpl extends BaseServiceImpl<Hotel> implements HotelService {

    @Autowired
    HotelRepository hotelRepository;

    @Override
    protected JpaRepository<Hotel, String> getRepository() {
        return hotelRepository;
    }

    @Override
    public Page<Hotel> findPageByNameLike(String keyword, Integer page, Integer size) {
        if (StringUtils.isEmpty(keyword)) {
            return hotelRepository.findAll(new PageRequest(page, size));
        }
        return hotelRepository.findByNameLike("%" + keyword + "%", new PageRequest(page, size));
    }
}
