package org.terry.magician.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author Terry
 */
@Entity
@Table(name = "line_order")
public class LineOrder extends BaseOrder {

    /**
     * 线路ID
     */
    @Column(name = "line_id", length = 64)
    private String lineId;
    /**
     * 下单会员
     */
    @Column(name = "member_id", length = 64)
    private String memberId;
    /**
     * 出发时间
     */
    @Column(name = "start_date")
    private Date startDate;
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
     * 预订人电子邮箱
     */
    @Column(name = "booking_person_email", length = 128)
    private String bookingPersonEmail;
    /**
     * 预订人备注
     */
    @Column(name = "booking_person_remark", length = 256)
    private String bookingPersonRemark;

    /**
     * 订单金额
     */
    @Column(name = "price", precision = 2)
    private Double price;

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getLineId() {
        return lineId;
    }

    public void setLineId(String lineId) {
        this.lineId = lineId;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
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

    public String getBookingPersonEmail() {
        return bookingPersonEmail;
    }

    public void setBookingPersonEmail(String bookingPersonEmail) {
        this.bookingPersonEmail = bookingPersonEmail;
    }

    public String getBookingPersonRemark() {
        return bookingPersonRemark;
    }

    public void setBookingPersonRemark(String bookingPersonRemark) {
        this.bookingPersonRemark = bookingPersonRemark;
    }

}
