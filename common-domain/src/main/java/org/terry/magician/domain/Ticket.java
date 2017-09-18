package org.terry.magician.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 景区门票
 *
 * @author Terry
 */
@Entity
@Table(name = "ticket")
public class Ticket extends IDEntity {

    @Column(name = "name", length = 255)
    private String name;

    @Column(name = "scenery_id", length = 64)
    private String sceneryId;

    /**
     * 价格
     */
    @Column(name = "price")
    private Double price;

    /**
     * 门市价
     */
    @Column(name = "market_price")
    private Double marketPrice;

    @Column(name = "sort")
    private Integer sort;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSceneryId() {
        return sceneryId;
    }

    public void setSceneryId(String sceneryId) {
        this.sceneryId = sceneryId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(Double marketPrice) {
        this.marketPrice = marketPrice;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}
