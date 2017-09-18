package org.terry.magician.api.vo;

/**
 * @author Terry
 */
public class TicketOrderInfoVO extends BaseVO {
    private Boolean needCode;
    private String ticketId;
    private String ticketName;
    private String sceneryName;
    private String latestAllowPlayTime;

    public String getSceneryName() {
        return sceneryName;
    }

    public void setSceneryName(String sceneryName) {
        this.sceneryName = sceneryName;
    }

    public Boolean getNeedCode() {
        return needCode;
    }

    public void setNeedCode(Boolean needCode) {
        this.needCode = needCode;
    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public String getTicketName() {
        return ticketName;
    }

    public void setTicketName(String ticketName) {
        this.ticketName = ticketName;
    }

    public String getLatestAllowPlayTime() {
        return latestAllowPlayTime;
    }

    public void setLatestAllowPlayTime(String latestAllowPlayTime) {
        this.latestAllowPlayTime = latestAllowPlayTime;
    }

}
