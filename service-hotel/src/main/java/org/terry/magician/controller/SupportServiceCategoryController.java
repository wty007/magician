package org.terry.magician.controller;

import org.terry.magician.common.controller.AbstractCRUDController;
import org.terry.magician.constant.ServiceConstants;
import org.terry.magician.domain.SupportServiceCategory;
import org.terry.magician.repository.SupportServiceCategoryRepository;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Terry
 */
@RefreshScope
@Api
@RestController
@RequestMapping(ServiceConstants.PATH_SERVICE_CATEGORY)
public class SupportServiceCategoryController extends AbstractCRUDController<SupportServiceCategory, String> {

    @Autowired
    SupportServiceCategoryRepository supportServiceCategoryRepository;


    @Override
    protected JpaRepository<SupportServiceCategory, String> getRepository() {
        return supportServiceCategoryRepository;
    }
}
