package org.terry.magician.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author Terry
 */
@Entity
@Table(name = "line_order_insurance")
public class LineOrderInsurance extends IDEntity {

    /**
     * 订单ID
     */
    @Column(name = "line_order_id", length = 64)
    private String lineOrderId;

    /**
     * 保险ID
     */
    @Column(name = "insurance_id", length = 64)
    private String insuranceId;

    /**
     * 价格
     */
    @Column(name = "price")
    private Double price;

    public String getLineOrderId() {
        return lineOrderId;
    }

    public void setLineOrderId(String lineOrderId) {
        this.lineOrderId = lineOrderId;
    }

    public String getInsuranceId() {
        return insuranceId;
    }

    public void setInsuranceId(String insuranceId) {
        this.insuranceId = insuranceId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
