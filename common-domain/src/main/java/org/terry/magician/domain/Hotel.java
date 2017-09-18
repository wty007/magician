package org.terry.magician.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author Terry
 */
@Entity
@Table(name = "hotel")
public class Hotel extends IDEntity {

    /**
     * 名称
     */
    @Column(name = "name", length = 255)
    private String name;

    /**
     * 拼音
     */
    @Column(name = "pinyin", length = 255)
    private String pinyin;

    /**
     * 简称
     */
    @Column(name = "subtitle", length = 255)
    private String subtitle;

    /**
     * 联系信息
     */
    @Column(name = "contact_information", length = 255)
    private String contactInformation;

    /**
     * 开业时间
     */
    @Column(name = "opening_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    private Date openingTime;

    /**
     * 装修时间
     */
    @Column(name = "decoration_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    private Date decorationTime;
    /**
     * 起步价
     */
    @Column(name = "starting_price")
    private Double startingPrice;
    /**
     * 门市价
     */
    @Column(name = "market_price")
    private Double marketPrice;
    @Column(name = "address", length = 255)
    private String address;
    @Column(name = "type", length = 64)
    private String type;
    @Column(name = "level", length = 64)
    private String level;
    @Column(name = "brand", length = 64)
    private String brand;
    @Column(name = "brief_description", length = 255)
    private String briefDescription;
    @Column(name = "introduction", length = 1024)
    private String introduction;
    @Column(name = "traffic_guide", length = 1024)
    private String trafficGuide;
    @Column(name = "surrounding_environment", length = 1024)
    private String surroundingEnvironment;
    @Column(name = "position_distance", length = 1024)
    private String positionDistance;
    @Column(name = "special_tips", length = 1024)
    private String specialTips;
    @Column(name = "append_service", length = 1024)
    private String appendService;
    @Column(name = "status")
    private Integer status;
    @Column(name = "hide")
    private Boolean hide;
    @Column(name = "recommend")
    private Boolean recommend;
    @Column(name = "sort")
    private Integer sort;
    @Column(name = "video_url", length = 255)
    private String videoUrl;

    public Double getStartingPrice() {
        return startingPrice;
    }

    public void setStartingPrice(Double startingPrice) {
        this.startingPrice = startingPrice;
    }

    public Double getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(Double marketPrice) {
        this.marketPrice = marketPrice;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean getHide() {
        return hide;
    }

    public void setHide(Boolean hide) {
        this.hide = hide;
    }

    public Boolean getRecommend() {
        return recommend;
    }

    public void setRecommend(Boolean recommend) {
        this.recommend = recommend;
    }

    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getContactInformation() {
        return contactInformation;
    }

    public void setContactInformation(String contactInformation) {
        this.contactInformation = contactInformation;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBriefDescription() {
        return briefDescription;
    }

    public void setBriefDescription(String briefDescription) {
        this.briefDescription = briefDescription;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getTrafficGuide() {
        return trafficGuide;
    }

    public void setTrafficGuide(String trafficGuide) {
        this.trafficGuide = trafficGuide;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
