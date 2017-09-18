package org.terry.magician.common.service;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Terry
 */
public interface SMSServiceDefinition {

    @RequestMapping(value = "new")
    Boolean sendText(@RequestParam("mobilePhone") String mobilePhone, @RequestParam("code") String code);

    @RequestMapping(value = "verify")
    Boolean sendVoice(@RequestParam("mobilePhone") String mobilePhone, @RequestParam("code") String code);
}
