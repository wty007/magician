package org.terry.magician.controller;

import org.terry.magician.common.controller.BaseCRUDController;
import org.terry.magician.common.service.HotelServiceDefinition;
import org.terry.magician.constant.PageConstants;
import org.terry.magician.domain.Hotel;
import org.terry.magician.domain.PageImplWrapper;
import org.terry.magician.repository.HotelRepository;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.data.domain.PageRequest;
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
public class HotelController extends BaseCRUDController<Hotel, String> implements HotelServiceDefinition {

    @Autowired
    HotelRepository hotelRepository;

    @Override
    protected JpaRepository<Hotel, String> getRepository() {
        return hotelRepository;
    }

    @Override
    public PageImplWrapper<Hotel> getPage(
            @RequestParam(value = "page", required = false, defaultValue = PageConstants.DEFAULT_PAGE_NUMBER) Integer page,
            @RequestParam(value = "size", required = false, defaultValue = PageConstants.DEFAULT_PAGE_SIZE) Integer size,
            @RequestParam(value = "sort", required = false, defaultValue = "") List<String> sorts) {
        return super.baseGetPage(page, size, sorts);
    }

    @Override
    public PageImplWrapper<Hotel> search(
            @RequestParam("city") String city, @RequestParam("checkInTime") String checkInTimeString, @RequestParam("leaveTime") String leaveTimeString,
            @RequestParam("keyword") String keyword, @RequestParam("page") Integer page, @RequestParam("size") Integer size) {
        return new PageImplWrapper<Hotel>(hotelRepository.findByNameLike("%" + keyword + "%", new PageRequest(page, size)));
    }

    @Override
    public List<Hotel> getList() {
        return super.baseGetList();
    }

    @Override
    public Hotel deleteById(@RequestParam("id") String s) {
        return super.baseDeleteById(s);
    }

    @Override
    public Hotel getById(@RequestParam("id") String s) {
        return super.baseGetById(s);
    }

    @Override
    public Hotel save(@RequestParam("dtoJson") String dtoJson) {
        return super.baseSave(dtoJson);
    }

    @Override
    public List<Hotel> getRecommendList() {
        return hotelRepository.findByRecommend(Boolean.TRUE);
    }


}
