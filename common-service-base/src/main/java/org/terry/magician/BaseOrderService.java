package org.terry.magician;

import org.terry.magician.domain.BaseOrder;
import org.terry.magician.domain.OrderStatusEnum;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * @author Terry
 */
public interface BaseOrderService<T extends BaseOrder> extends BaseService<T> {

    Page<T> findByMemberId(String memberId, PageRequest pageRequest);

    Page<T> findPageByMemberIdAndStatues(String memberId, List<OrderStatusEnum> statusEnumList, Integer page, Integer size);

    Page<T> findPageByMemberId(String memberId, Integer page, Integer size);

    List<T> findByMemberIdAndStatues(String memberId, List<OrderStatusEnum> statusEnumList);

    T getBySn(String sn);

}
