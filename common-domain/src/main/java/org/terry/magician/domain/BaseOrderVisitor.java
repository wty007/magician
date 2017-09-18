package org.terry.magician.domain;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * 线路订单游客
 *
 * @author Terry
 */
@MappedSuperclass
public class BaseOrderVisitor extends IDEntity {

    /**
     * 姓名
     */
    @Column(name = "name", length = 64)
    private String name;

    /**
     * 订单ID
     */
    @Column(name = "order_id", length = 64)
    private String orderId;

    /**
     * 成人 or 小孩
     *
     * @see LineVisitorTypeEnum
     */
    @Column(name = "type")
    private Integer type;

    /**
     * 证件类型
     */
    @Column(name = "certificate_type")
    private Integer certificateType;

    /**
     * 证件号码
     */
    @Column(name = "certificate_number", length = 32)
    private String certificateNumber;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCertificateType() {
        return certificateType;
    }

    public void setCertificateType(Integer certificateType) {
        this.certificateType = certificateType;
    }

    public String getCertificateNumber() {
        return certificateNumber;
    }

    public void setCertificateNumber(String certificateNumber) {
        this.certificateNumber = certificateNumber;
    }
}
