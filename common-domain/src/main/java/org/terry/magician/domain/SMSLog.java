package org.terry.magician.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author Terry
 */
@Entity
@Table(name = "sms_log")
public class SMSLog extends IDEntity {

    @Column(name = "code", length = 32)
    private String code;

    @Column(name = "mobile_phone", length = 32)
    private String mobilePhone;

    @Column(name = "type", length = 32)
    private Integer type;

    @Column(name = "origin_result", length = 64)
    private String originResult;

    @Column(name = "send_time")
    private Date sendTime;

    @Column(name = "stat")
    private Integer stat;//状态

    @Column(name = "return_code")
    private String returnCode;//返回码

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public String getOriginResult() {
        return originResult;
    }

    public void setOriginResult(String originResult) {
        this.originResult = originResult;
    }

    public Integer getStat() {
        return stat;
    }

    public void setStat(Integer stat) {
        this.stat = stat;
    }

    public String getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }
}
