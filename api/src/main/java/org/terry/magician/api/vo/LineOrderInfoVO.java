package org.terry.magician.api.vo;

import java.util.List;

/**
 * @author Terry
 */
public class LineOrderInfoVO extends BaseVO {
    private Boolean needCode;
    private String lineId;
    private String lineName;
    private String latestStartingTime;
    private List<InsuranceVO> insurances;

    public Boolean getNeedCode() {
        return needCode;
    }

    public void setNeedCode(Boolean needCode) {
        this.needCode = needCode;
    }

    public String getLineId() {
        return lineId;
    }

    public void setLineId(String lineId) {
        this.lineId = lineId;
    }

    public String getLineName() {
        return lineName;
    }

    public void setLineName(String lineName) {
        this.lineName = lineName;
    }

    public String getLatestStartingTime() {
        return latestStartingTime;
    }

    public void setLatestStartingTime(String latestStartingTime) {
        this.latestStartingTime = latestStartingTime;
    }

    public List<InsuranceVO> getInsurances() {
        return insurances;
    }

    public void setInsurances(List<InsuranceVO> insurances) {
        this.insurances = insurances;
    }
}
