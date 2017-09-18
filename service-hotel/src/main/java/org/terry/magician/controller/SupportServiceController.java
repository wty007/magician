package org.terry.magician.controller;

import org.terry.magician.common.controller.AbstractCRUDController;
import org.terry.magician.constant.ServiceConstants;
import org.terry.magician.domain.SupportService;
import org.terry.magician.repository.SupportServiceRepository;
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
@RequestMapping(ServiceConstants.PATH_SERVICE)
public class SupportServiceController extends AbstractCRUDController<SupportService, String> {

    @Autowired
    SupportServiceRepository supportServiceRepository;

    @Override
    protected JpaRepository<SupportService, String> getRepository() {
        return supportServiceRepository;
    }
}
