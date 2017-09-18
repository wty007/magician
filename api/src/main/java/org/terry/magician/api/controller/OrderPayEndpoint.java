package org.terry.magician.api.controller;

import org.terry.magician.api.service.PayService;
import org.terry.magician.api.service.impl.PayStatusEnum;
import org.terry.magician.api.support.APIResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Terry
 */
@RestController
public class OrderPayEndpoint {

    @Autowired
    PayService payService;

    @RequestMapping("order/pay/status/update")
    public Object lineOrderPayStatusUpdate(@RequestParam("orderId") String orderId) {

        payService.updateOrderStatus(orderId);

        return APIResult.createSuccess();
    }

}
