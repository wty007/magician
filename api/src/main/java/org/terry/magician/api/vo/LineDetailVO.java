package org.terry.magician.api.vo;

import java.util.List;

/**
 * @author Terry
 */
public class LineDetailVO extends LineItemVO {

    /**
     * 预订须知
     */
    private String bookingInformation;

    /**
     * 出发城市
     */
    private String startCity;

    /**
     * 图片地址列表
     */
    private List<String> pics;

    /**
     * 标签列表
     */
    private List<String> labels;

    /**
     * 行程介绍
     */
    private String travelIntroduction;

    /**
     * 费用介绍
     */
    private String costIntroduction;

    public String getBookingInformation() {
        return bookingInformation;
    }

    public void setBookingInformation(String bookingInformation) {
        this.bookingInformation = bookingInformation;
    }

    public String getStartCity() {
        return startCity;
    }

    public void setStartCity(String startCity) {
        this.startCity = startCity;
    }

    public String getCostIntroduction() {
        return costIntroduction;
    }

    public void setCostIntroduction(String costIntroduction) {
        this.costIntroduction = costIntroduction;
    }

    public List<String> getPics() {
        return pics;
    }

    public void setPics(List<String> pics) {
        this.pics = pics;
    }

    public List<String> getLabels() {
        return labels;
    }

    public void setLabels(List<String> labels) {
        this.labels = labels;
    }

    public String getTravelIntroduction() {
        return travelIntroduction;
    }

    public void setTravelIntroduction(String travelIntroduction) {
        this.travelIntroduction = travelIntroduction;
    }
}
