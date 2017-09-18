package org.terry.magician.domain;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Terry
 */
@Entity
@Table(name = "hotel_support_service")
public class HotelSupportService extends IDEntity {

    @JoinColumn(name = "service_id")
    @ManyToOne
    private SupportService service;

    @JoinColumn(name = "hotel_id")
    @ManyToOne
    private Hotel hotel;

    public SupportService getService() {
        return service;
    }

    public void setService(SupportService service) {
        this.service = service;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }
}
