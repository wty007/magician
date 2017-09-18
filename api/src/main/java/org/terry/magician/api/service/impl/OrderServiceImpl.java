package org.terry.magician.api.service.impl;

import org.terry.magician.api.service.OrderService;
import org.terry.magician.domain.BaseOrder;
import org.terry.magician.domain.OrderStatusEnum;
import org.springframework.stereotype.Service;

/**
 * @author Terry
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Override
    public boolean canChangeStatus(OrderStatusEnum fromStatus, OrderStatusEnum toStatus) {

        if (toStatus.equals(OrderStatusEnum.CANCEL)) {
            return true;
        }

        return fromStatus.getId() < toStatus.getId();
    }

    @Override
    public void changeStatus(BaseOrder order, OrderStatusEnum fromStatus, OrderStatusEnum toStatus) {
        if (canChangeStatus(fromStatus, toStatus)) {
            order.setStatus(toStatus.getId());
        }

        //todo 记录日志
    }

    @Override
    public Integer[] getRealOrderStatues(Integer status) {

        if (status.equals(ORDER_STATUS_UN_PAID)) {
            return new Integer[]{OrderStatusEnum.UN_PAID.getId()};
        } else if (status.equals(ORDER_STATUS_COMPLETED)) {
            return new Integer[]{
                    OrderStatusEnum.PAID.getId(),
                    OrderStatusEnum.UN_PROCESS.getId(),
                    OrderStatusEnum.PROCESSED.getId(),
                    OrderStatusEnum.UN_ING.getId(),
                    OrderStatusEnum.ING.getId(),
                    OrderStatusEnum.COMPLETED.getId()
            };
        } else if (status.equals(ORDER_STATUS_CANCEL)) {
            return new Integer[]{OrderStatusEnum.CANCEL.getId()};
        } else if (status.equals(ORDER_STATUS_ALL)) {
            return new Integer[]{
                    OrderStatusEnum.UN_PAID.getId(),
                    OrderStatusEnum.PAID.getId(),
                    OrderStatusEnum.UN_PROCESS.getId(),
                    OrderStatusEnum.PROCESSED.getId(),
                    OrderStatusEnum.UN_ING.getId(),
                    OrderStatusEnum.ING.getId(),
                    OrderStatusEnum.COMPLETED.getId(),
                    OrderStatusEnum.CANCEL.getId()
            };
        }

        return new Integer[]{};
    }
}
