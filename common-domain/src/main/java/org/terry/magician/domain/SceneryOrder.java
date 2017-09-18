package org.terry.magician.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author Terry
 */
@Entity
@Table(name = "scenery_order")
public class SceneryOrder extends BaseOrder {

    /**
     * 景区ID
     */
    @Column(name = "scenery_id", length = 64)
    private String sceneryId;

    /**
     * 下单会员
     */
    @Column(name = "member_id", length = 64)
    private String memberId;

    /**
     * 游玩时间
     */
    @Column(name = "play_time")
    private Date playTime;

    /**
     * 票数
     */
    @Column(name = "count")
    private Integer count;

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

    public String getSceneryId() {
        return sceneryId;
    }

    public void setSceneryId(String sceneryId) {
        this.sceneryId = sceneryId;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public Date getPlayTime() {
        return playTime;
    }

    public void setPlayTime(Date playTime) {
        this.playTime = playTime;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
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
