package org.terry.magician.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author Terry
 */
@Entity
@Table(name = "ticket_order")
public class TicketOrder extends BaseOrder {

    /**
     * 景区ID
     */
    @Column(name = "scenery_id", length = 64)
    private String sceneryId;

    /**
     * 景区门票ID
     */
    @Column(name = "ticket_id", length = 64)
    private String ticketId;


    /**
     * 游玩时间
     */
    @Column(name = "play_time")
    private Date playTime;

    /**
     * 成人数量
     */
    @Column(name = "adult_count")
    private Integer adultCount;

    /**
     * 儿童数量
     */
    @Column(name = "child_count")
    private Integer childCount;

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

    /**
     * 订单金额
     */
    @Column(name = "price", precision = 2)
    private Double price;


    public String getSceneryId() {
        return sceneryId;
    }

    public void setSceneryId(String sceneryId) {
        this.sceneryId = sceneryId;
    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public Date getPlayTime() {
        return playTime;
    }

    public void setPlayTime(Date playTime) {
        this.playTime = playTime;
    }

    public Integer getAdultCount() {
        return adultCount;
    }

    public void setAdultCount(Integer adultCount) {
        this.adultCount = adultCount;
    }

    public Integer getChildCount() {
        return childCount;
    }

    public void setChildCount(Integer childCount) {
        this.childCount = childCount;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
