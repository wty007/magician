package org.terry.magician.api.service;

import org.terry.magician.domain.BaseOrder;
import org.terry.magician.domain.OrderStatusEnum;

/**
 * @author Terry
 */
public interface OrderService {

    int ORDER_STATUS_ALL = 0;
    int ORDER_STATUS_UN_PAID = 1;
    int ORDER_STATUS_COMPLETED = 2;
    int ORDER_STATUS_CANCEL = 3;

    boolean canChangeStatus(OrderStatusEnum fromStatus, OrderStatusEnum toStatus);

    void changeStatus(BaseOrder order, OrderStatusEnum fromStatus, OrderStatusEnum toStatus);

    Integer[] getRealOrderStatues(Integer status);
}
