package org.terry.magician.controller;

import org.terry.magician.common.controller.BaseCRUDController;
import org.terry.magician.common.service.LineServiceDefinition;
import org.terry.magician.constant.PageConstants;
import org.terry.magician.domain.Line;
import org.terry.magician.domain.PageImplWrapper;
import org.terry.magician.repository.LineRepository;
import org.terry.magician.service.LineService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Terry
 */
@RefreshScope
@Api
@RestController
public class LineController extends BaseCRUDController<Line, String> implements LineServiceDefinition {

    @Autowired
    LineRepository lineRepository;

    @Autowired
    LineService lineService;

    @Override
    protected JpaRepository<Line, String> getRepository() {
        return lineRepository;
    }

    @Override
    public PageImplWrapper<Line> getPage(
            @RequestParam(value = "page", required = false, defaultValue = PageConstants.DEFAULT_PAGE_NUMBER) Integer page,
            @RequestParam(value = "size", required = false, defaultValue = PageConstants.DEFAULT_PAGE_SIZE) Integer size,
            @RequestParam(value = "sort", required = false, defaultValue = "") List<String> sorts) {
        return super.baseGetPage(page, size, sorts);
    }

    @Override
    public PageImplWrapper<Line> search(
            @RequestParam("city") String city, @RequestParam("keyword") String keyword,
            @RequestParam("page") Integer page, @RequestParam("size") Integer size) {
        return new PageImplWrapper<Line>(lineService.findPageByNameLike(keyword, page, size));
    }

    @Override
    public List<Line> getList() {
        return super.baseGetList();
    }

    @Override
    public Boolean deleteById(@RequestParam("id") String s) {
        super.baseDeleteById(s);
        return Boolean.TRUE;
    }

    @Override
    public Line getById(@RequestParam("id") String s) {
        return super.baseGetById(s);
    }

    @Override
    public Line save(@RequestParam("dtoJson") String dtoJson) {
        return super.baseSave(dtoJson);
    }

    @Override
    public List<Line> getRecommendList() {
        return lineRepository.findByRecommend(Boolean.TRUE);
    }
}
