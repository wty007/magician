package org.terry.magician.api.service;

import org.terry.magician.domain.PayTypeEnum;

/**
 * @author Terry
 */
public interface OrderPayNotifyService {
    void success(String orderId, PayTypeEnum payTypeEnum) ;

    void fail(String merOrderId, PayTypeEnum quick);
}
