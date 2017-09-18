package org.terry.magician.api.vo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.List;

/**
 * @author Terry
 */
public class HotelDetailVO extends HotelItemVO {

    /**
     * 房间列表
     */
    private List<RoomVO> rooms;

    /**
     * 开业时间
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    private Date openingTime;

    /**
     * 装修时间
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    private Date decorationTime;

    /**
     * 周围环境
     */
    private String surroundingEnvironment;

    /**
     * 位置距离
     */
    private String positionDistance;

    /**
     * 特别提示
     */
    private String specialTips;

    /**
     * 附加服务
     */
    private String appendService;

    /**
     * 联系方式
     */
    private String contactInformation;

    /**
     * 图片地址列表
     */
    private List<String> pics;

    public List<RoomVO> getRooms() {
        return rooms;
    }

    public void setRooms(List<RoomVO> rooms) {
        this.rooms = rooms;
    }

    public String getContactInformation() {
        return contactInformation;
    }

    public void setContactInformation(String contactInformation) {
        this.contactInformation = contactInformation;
    }

    public List<String> getPics() {
        return pics;
    }

    public void setPics(List<String> pics) {
        this.pics = pics;
    }

    public String getSurroundingEnvironment() {
        return surroundingEnvironment;
    }

    public void setSurroundingEnvironment(String surroundingEnvironment) {
        this.surroundingEnvironment = surroundingEnvironment;
    }

    public String getPositionDistance() {
        return positionDistance;
    }

    public void setPositionDistance(String positionDistance) {
        this.positionDistance = positionDistance;
    }

    public String getSpecialTips() {
        return specialTips;
    }

    public void setSpecialTips(String specialTips) {
        this.specialTips = specialTips;
    }

    public String getAppendService() {
        return appendService;
    }

    public void setAppendService(String appendService) {
        this.appendService = appendService;
    }

    public Date getOpeningTime() {
        return openingTime;
    }

    public void setOpeningTime(Date openingTime) {
        this.openingTime = openingTime;
    }

    public Date getDecorationTime() {
        return decorationTime;
    }

    public void setDecorationTime(Date decorationTime) {
        this.decorationTime = decorationTime;
    }
}
