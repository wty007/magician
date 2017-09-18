package org.terry.magician.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 宾馆房间
 *
 * @author Terry
 */
@Entity
@Table(name = "room")
public class Room extends IDEntity {

    @Column(name = "name", length = 255)
    private String name;

    @Column(name = "hotel_id", length = 64)
    private String hotelId;

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

    /**
     * 排序
     */
    @Column(name = "sort")
    private Integer sort;

    public String getHotelId() {
        return hotelId;
    }

    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
