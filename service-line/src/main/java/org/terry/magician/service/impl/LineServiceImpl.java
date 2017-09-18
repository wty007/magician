package org.terry.magician.service.impl;

import org.terry.magician.BaseServiceImpl;
import org.terry.magician.domain.Line;
import org.terry.magician.repository.LineRepository;
import org.terry.magician.service.LineService;
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
public class LineServiceImpl extends BaseServiceImpl<Line> implements LineService {

    @Autowired
    LineRepository lineRepository;

    @Override
    protected JpaRepository<Line, String> getRepository() {
        return lineRepository;
    }

    @Override
    public Page<Line> findPageByNameLike(String keyword, Integer page, Integer size) {
        if (StringUtils.isEmpty(keyword)) {
            return lineRepository.findAll(new PageRequest(page, size));
        }
        return lineRepository.findByNameLike("%" + keyword + "%", new PageRequest(page, size));
    }
}
