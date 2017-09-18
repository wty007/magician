package org.terry.magician.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 酒店订单入住人
 *
 * @author Terry
 */
@Entity
@Table(name = "hotel_order_person")
public class HotelOrderPerson extends IDEntity {

    /**
     * 订单ID
     */
    @Column(name = "hotel_order_id", length = 64)
    private String hotelOrderId;

    /**
     * 姓名
     */
    @Column(name = "name", length = 16)
    private String name;

    /**
     * 排序
     */
    @Column(name = "sort")
    private Integer sort;

    public String getHotelOrderId() {
        return hotelOrderId;
    }

    public void setHotelOrderId(String hotelOrderId) {
        this.hotelOrderId = hotelOrderId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}
