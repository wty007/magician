package org.terry.magician.controller;

import org.terry.magician.common.controller.AbstractCRUDController;
import org.terry.magician.domain.Visa;
import org.terry.magician.repository.VisaRepository;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Terry
 */
@RefreshScope
@Api
@RestController
public class VisaController extends AbstractCRUDController<Visa, String> {

    @Autowired
    VisaRepository visaRepository;

    @Override
    protected JpaRepository<Visa, String> getRepository() {
        return visaRepository;
    }
}
