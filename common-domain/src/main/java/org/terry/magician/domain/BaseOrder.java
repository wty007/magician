package org.terry.magician.domain;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.util.Date;

/**
 * @author Terry
 */
@MappedSuperclass
public class BaseOrder extends IDEntity {

    /**
     * 订单编号
     *
     * @see OrderStatusEnum
     */
    @Column(name = "sn")
    private String sn;

    /**
     * 订单状态
     *
     * @see OrderStatusEnum
     */
    @Column(name = "status")
    private Integer status;

    /**
     * 取消原因
     */
    @Column(name = "cancel_reason", length = 64)
    private String cancelReason;

    /**
     * 下单会员
     */
    @Column(name = "member_id", length = 64)
    private String memberId;
    /**
     * 下单时间
     */
    @Column(name = "create_time")
    private Date createTime;

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

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCancelReason() {
        return cancelReason;
    }

    public void setCancelReason(String cancelReason) {
        this.cancelReason = cancelReason;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }
}
