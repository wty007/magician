package org.terry.magician.controller;

import org.terry.magician.common.controller.AbstractCRUDController;
import org.terry.magician.domain.Dict;
import org.terry.magician.repository.DictRepository;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Terry
 */
@RefreshScope
@Api
@RestController
public class DictController extends AbstractCRUDController<Dict, String> {

    @Autowired
    DictRepository dictRepository;

    @Override
    protected JpaRepository<Dict, String> getRepository() {
        return dictRepository;
    }

    @RequestMapping("findByType")
    public List<Dict> findByType(@RequestParam("type") String type) {
        return dictRepository.findByTypeOrderBySortAsc(type);
    }

}
