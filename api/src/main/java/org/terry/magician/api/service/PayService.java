package org.terry.magician.api.service;

import org.terry.magician.api.service.impl.PayStatusEnum;

/**
 * @author Terry
 */
public interface PayService {

    String getPayString(String orderId, Double price);

    void updateOrderStatus(String orderId);

}
