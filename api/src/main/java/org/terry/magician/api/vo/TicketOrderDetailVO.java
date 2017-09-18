package org.terry.magician.api.vo;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Date;

/**
 * @author Terry
 */
public class TicketOrderDetailVO extends BaseOrderDetailVO {

    /**
     * 景区ID
     */
    private String sceneryId;
    /**
     * 景区名称
     */
    private String sceneryName;
    /**
     * 门票ID
     */
    private String ticketId;
    /**
     * 门票名称
     */
    private String ticketName;
    /**
     * 游玩时间(yyyy-MM-dd)
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date playTime;

    /**
     * 数量
     */
    private Integer adultCount;

    private Integer childCount;

    public Integer getAdultCount() {
        return adultCount;
    }

    public void setAdultCount(Integer adultCount) {
        this.adultCount = adultCount;
    }

    public Integer getChildCount() {
        return childCount;
    }

    public void setChildCount(Integer childCount) {
        this.childCount = childCount;
    }

    public String getTicketName() {
        return ticketName;
    }

    public void setTicketName(String ticketName) {
        this.ticketName = ticketName;
    }


    public String getSceneryId() {
        return sceneryId;
    }

    public void setSceneryId(String sceneryId) {
        this.sceneryId = sceneryId;
    }

    public String getSceneryName() {
        return sceneryName;
    }

    public void setSceneryName(String sceneryName) {
        this.sceneryName = sceneryName;
    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public Date getPlayTime() {
        return playTime;
    }

    public void setPlayTime(Date playTime) {
        this.playTime = playTime;
    }

}
