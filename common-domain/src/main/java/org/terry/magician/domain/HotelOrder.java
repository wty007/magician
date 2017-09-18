package org.terry.magician.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author Terry
 */
@Entity
@Table(name = "hotel_order")
public class HotelOrder extends BaseOrder {

    /**
     * 酒店ID
     */
    @Column(name = "hotel_id", length = 64)
    private String hotelId;

    /**
     * 下单会员
     */
    @Column(name = "member_id", length = 64)
    private String memberId;

    /**
     * 入住时间
     */
    @Column(name = "check_in_time")
    private Date checkInTime;

    /**
     * 房间保留到N点
     */
    @Column(name = "keep_till_time")
    private Date keepTillTime;

    /**
     * 离店时间
     */
    @Column(name = "leave_time")
    private Date leaveTime;

    /**
     * 房间数
     */
    @Column(name = "room_count")
    private Integer roomCount;

    /**
     * 预订人真实姓名
     */
    @Column(name = "booking_person_real_name", length = 16)
    private String bookingPersonRealName;
    /**
     * 预订人手机号
     */
    @Column(name = "booking_person_mobile_phone", length = 16)
    private String bookingPersonMobilePhone;


    public String getHotelId() {
        return hotelId;
    }

    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public Date getCheckInTime() {
        return checkInTime;
    }

    public void setCheckInTime(Date checkInTime) {
        this.checkInTime = checkInTime;
    }

    public Date getKeepTillTime() {
        return keepTillTime;
    }

    public void setKeepTillTime(Date keepTillTime) {
        this.keepTillTime = keepTillTime;
    }

    public Date getLeaveTime() {
        return leaveTime;
    }

    public void setLeaveTime(Date leaveTime) {
        this.leaveTime = leaveTime;
    }

    public Integer getRoomCount() {
        return roomCount;
    }

    public void setRoomCount(Integer roomCount) {
        this.roomCount = roomCount;
    }

    public String getBookingPersonRealName() {
        return bookingPersonRealName;
    }

    public void setBookingPersonRealName(String bookingPersonRealName) {
        this.bookingPersonRealName = bookingPersonRealName;
    }

    public String getBookingPersonMobilePhone() {
        return bookingPersonMobilePhone;
    }

    public void setBookingPersonMobilePhone(String bookingPersonMobilePhone) {
        this.bookingPersonMobilePhone = bookingPersonMobilePhone;
    }
}
