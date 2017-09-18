package org.terry.magician.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 保险
 *
 * @author Terry
 */
@Entity
@Table(name = "insurance")
public class Insurance extends IDEntity {

    /**
     * 价格
     */
    @Column(name = "price")
    private Double price;

    /**
     * 价格
     */
    @Column(name = "name")
    private String name;

    /**
     * 期限
     */
    @Column(name = "period")
    private String period;

    /**
     * 说明
     */
    @Column(name = "description")
    private String description;

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
