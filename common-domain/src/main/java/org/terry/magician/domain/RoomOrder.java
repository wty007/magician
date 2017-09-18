package org.terry.magician.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author Terry
 */
@Entity
@Table(name = "room_order")
public class RoomOrder extends BaseOrder {

    /**
     * 景区ID
     */
    @Column(name = "hotel_id", length = 64)
    private String hotelId;

    /**
     * 房间ID
     */
    @Column(name = "room_id", length = 64)
    private String roomId;


    /**
     * 入住时间
     */
    @Column(name = "check_in_time")
    private Date checkInTime;

    /**
     * 房间保留到N点
     */
    @Column(name = "keep_till_time")
    private Integer keepTillTime;

    /**
     * 离店时间
     */
    @Column(name = "leave_time")
    private Date leaveTime;

    /**
     * 数量
     */
    @Column(name = "count")
    private Integer count;

    public String getHotelId() {
        return hotelId;
    }

    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public Date getCheckInTime() {
        return checkInTime;
    }

    public void setCheckInTime(Date checkInTime) {
        this.checkInTime = checkInTime;
    }

    public Integer getKeepTillTime() {
        return keepTillTime;
    }

    public void setKeepTillTime(Integer keepTillTime) {
        this.keepTillTime = keepTillTime;
    }

    public Date getLeaveTime() {
        return leaveTime;
    }

    public void setLeaveTime(Date leaveTime) {
        this.leaveTime = leaveTime;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

}
