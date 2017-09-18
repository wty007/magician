package org.terry.magician.api.service.impl;

import org.terry.magician.api.service.OrderPayNotifyService;
import org.terry.magician.api.service.PayService;
import org.terry.magician.common.util.JsonService;
import org.terry.magician.domain.PayTypeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Terry
 */
@Service
public class PayServiceImpl implements PayService {
    @Autowired
    OrderPayNotifyService orderPayNotifyService;
    @Autowired
    JsonService jsonService;

    @Override
    public void updateOrderStatus(String orderId) {
        orderPayNotifyService.success("orderId", PayTypeEnum.QUICK);
        orderPayNotifyService.fail("orderId", PayTypeEnum.QUICK);
    }

    @Override
    public String getPayString(String orderSn, Double price) {
        //// TODO: 2017-08-03
        return "";
    }
}
