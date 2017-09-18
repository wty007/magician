package org.terry.magician.controller;

import org.terry.magician.common.controller.BaseCRUDController;
import org.terry.magician.common.service.SceneryServiceDefinition;
import org.terry.magician.constant.PageConstants;
import org.terry.magician.domain.PageImplWrapper;
import org.terry.magician.domain.Scenery;
import org.terry.magician.repository.SceneryRepository;
import org.terry.magician.service.SceneryService;
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
public class SceneryController extends BaseCRUDController<Scenery, String> implements SceneryServiceDefinition {

    @Autowired
    SceneryRepository sceneryRepository;

    @Autowired
    SceneryService sceneryService;

    @Override
    protected JpaRepository<Scenery, String> getRepository() {
        return sceneryRepository;
    }

    @Override
    public PageImplWrapper<Scenery> getPage(
            @RequestParam(value = "page", required = false, defaultValue = PageConstants.DEFAULT_PAGE_NUMBER) Integer page,
            @RequestParam(value = "size", required = false, defaultValue = PageConstants.DEFAULT_PAGE_SIZE) Integer size,
            @RequestParam(value = "sort", required = false, defaultValue = "") List<String> sorts) {
        return super.baseGetPage(page, size, sorts);
    }

    @Override
    public PageImplWrapper<Scenery> search(
            @RequestParam("city") String city,
            @RequestParam("keyword") String keyword,
            @RequestParam("page") Integer page,
            @RequestParam("size") Integer size) {
        return new PageImplWrapper<Scenery>(sceneryService.findPageByNameLike(keyword, page, size));
    }

    @Override
    public List<Scenery> getList() {
        return super.baseGetList();
    }

    @Override
    public Scenery deleteById(@RequestParam("id") String s) {
        return super.baseDeleteById(s);
    }

    @Override
    public Scenery getById(@RequestParam("id") String s) {
        return super.baseGetById(s);
    }

    @Override
    public Scenery save(@RequestParam("dtoJson") String dtoJson) {
        return super.baseSave(dtoJson);
    }

    @Override
    public List<Scenery> getRecommendList() {
        return sceneryRepository.findByRecommend(Boolean.TRUE);
    }


}

