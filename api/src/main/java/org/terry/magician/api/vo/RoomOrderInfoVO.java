package org.terry.magician.api.vo;

import java.util.Date;

/**
 * @author Terry
 */
public class RoomOrderInfoVO extends BaseVO {

    private Boolean needCode;
    private String roomId;
    private String roomName;
    private String hotelName;
    private Date checkInTime;
    private Date leaveTime;

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public Boolean getNeedCode() {
        return needCode;
    }

    public void setNeedCode(Boolean needCode) {
        this.needCode = needCode;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }


}
