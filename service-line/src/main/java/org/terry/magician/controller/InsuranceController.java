package org.terry.magician.controller;

import org.terry.magician.common.controller.AbstractCRUDController;
import org.terry.magician.constant.ServiceConstants;
import org.terry.magician.domain.Insurance;
import org.terry.magician.repository.InsuranceRepository;
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
@RequestMapping(ServiceConstants.LINE_SERVICE_PATH_INSURANCE)
public class InsuranceController extends AbstractCRUDController<Insurance, String> {

    @Autowired
    InsuranceRepository insuranceRepository;

    @Override
    protected JpaRepository<Insurance, String> getRepository() {
        return insuranceRepository;
    }

}
