package org.terry.magician.api.vo;

import java.util.List;

/**
 * @author Terry
 */
public class SceneryDetailVO extends SceneryItemVO {

    /**
     * 门票
     */
    private List<TicketVO> tickets;

    /**
     * 开放时间
     */
    private String openingTime;

    /**
     * 地址
     */
    private String address;

    /**
     * 交通指南
     */
    private String trafficGuide;

    /**
     * 预订须知
     */
    private String buyTicketNotes;

    /**
     * 图片地址列表
     */
    private List<String> pics;

    public String getTrafficGuide() {
        return trafficGuide;
    }

    public void setTrafficGuide(String trafficGuide) {
        this.trafficGuide = trafficGuide;
    }

    public List<TicketVO> getTickets() {
        return tickets;
    }

    public void setTickets(List<TicketVO> tickets) {
        this.tickets = tickets;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<String> getPics() {
        return pics;
    }

    public void setPics(List<String> pics) {
        this.pics = pics;
    }

    public String getOpeningTime() {
        return openingTime;
    }

    public void setOpeningTime(String openingTime) {
        this.openingTime = openingTime;
    }

    public String getBuyTicketNotes() {
        return buyTicketNotes;
    }

    public void setBuyTicketNotes(String buyTicketNotes) {
        this.buyTicketNotes = buyTicketNotes;
    }
}
