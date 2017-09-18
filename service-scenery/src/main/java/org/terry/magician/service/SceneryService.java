package org.terry.magician.service;

import org.terry.magician.BaseService;
import org.terry.magician.domain.Scenery;
import org.springframework.data.domain.Page;

/**
 * @author Terry
 */
public interface SceneryService extends BaseService<Scenery> {
    Page<Scenery> findPageByNameLike(String keyword, Integer page, Integer size);
}
