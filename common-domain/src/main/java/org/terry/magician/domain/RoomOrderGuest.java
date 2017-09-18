package org.terry.magician.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 酒店房间住客信息表
 *
 * @author Terry
 */
@Entity
@Table(name = "room_order_guest")
public class RoomOrderGuest extends IDEntity {

    /**
     * 订单ID
     */
    @Column(name = "room_order_id", length = 64)
    private String roomOrderId;

    /**
     * 姓名
     */
    @Column(name = "name", length = 32)
    private String name;

    /**
     * 排序
     */
    @Column(name = "sort")
    private Integer sort;

    public String getRoomOrderId() {
        return roomOrderId;
    }

    public void setRoomOrderId(String roomOrderId) {
        this.roomOrderId = roomOrderId;
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
