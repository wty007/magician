package org.terry.magician.service;

import org.terry.magician.BaseService;
import org.terry.magician.domain.Line;
import org.springframework.data.domain.Page;

/**
 * @author Terry
 */
public interface LineService extends BaseService<Line> {
    Page<Line> findPageByNameLike(String keyword, Integer page, Integer size);
}
