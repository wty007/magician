package org.terry.magician.service.impl;

import org.terry.magician.BaseServiceImpl;
import org.terry.magician.domain.Scenery;
import org.terry.magician.repository.SceneryRepository;
import org.terry.magician.service.SceneryService;
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
public class SceneryServiceImpl extends BaseServiceImpl<Scenery> implements SceneryService {

    @Autowired
    SceneryRepository sceneryRepository;

    @Override
    protected JpaRepository<Scenery, String> getRepository() {
        return sceneryRepository;
    }


    @Override
    public Page<Scenery> findPageByNameLike(String keyword, Integer page, Integer size) {
        if (StringUtils.isEmpty(keyword)) {
            return sceneryRepository.findAll(new PageRequest(page, size));
        }
        return sceneryRepository.findByNameLike("%" + keyword + "%", new PageRequest(page, size));
    }
}
