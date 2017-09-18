package org.terry.magician.common.service;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Terry
 */
public interface VerifyCodeServiceDefinition {

    @RequestMapping(value = "new")
    String newOne(@RequestParam("owner") String owner, @RequestParam("type") Integer type, @RequestParam("expireMills") Integer expireMills);

    @RequestMapping(value = "verify")
    Boolean verify(@RequestParam("owner") String owner, @RequestParam("code") String code, @RequestParam("type") Integer type);
}
