package org.terry.magician.api.vo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @author Terry
 */
public class BaseOrderDetailVO extends BaseVO {

    private String id;

    /**
     * 订单编码
     */
    private String sn;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 取消原因
     */
    private String cancelReason;
    /**
     * 会员ID
     */
    private String memberId;

    /**
     * (yyyy-MM-dd HH:mm:ss)
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    private Double price;

    /**
     * 预订人真实姓名
     */
    private String bookingPersonRealName;

    /**
     * 预订人手机号
     */
    private String bookingPersonMobilePhone;

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
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

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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
