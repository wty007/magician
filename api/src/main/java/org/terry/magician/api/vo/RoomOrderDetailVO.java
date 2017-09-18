package org.terry.magician.api.vo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @author Terry
 */
public class RoomOrderDetailVO extends BaseOrderDetailVO {

    /**
     * 数量
     */
    private Integer count;

    /**
     * 酒店ID
     */
    private String hotelId;

    /**
     * 房间ID
     */
    private String roomId;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date leaveTime;

    private String roomName;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date checkInTime;
    private String hotelName;


    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

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

    public Date getLeaveTime() {
        return leaveTime;
    }

    public void setLeaveTime(Date leaveTime) {
        this.leaveTime = leaveTime;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public Date getCheckInTime() {
        return checkInTime;
    }

    public void setCheckInTime(Date checkInTime) {
        this.checkInTime = checkInTime;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getHotelName() {
        return hotelName;
    }
}
