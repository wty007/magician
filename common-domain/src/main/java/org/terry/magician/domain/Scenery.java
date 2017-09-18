package org.terry.magician.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author Terry
 */
@Entity
@Table(name = "scenery")
public class Scenery extends IDEntity {

    @Column(name = "name", length = 255)
    private String name;

    @Column(name = "opening_time", length = 255)
    private String openingTime;

    @Column(name = "city", length = 255)
    private String city;

    @Column(name = "pinyin", length = 255)
    private String pinyin;

    @Column(name = "subtitle", length = 255)
    private String subtitle;

    @Column(name = "ticket_taking_place", length = 255)
    private String ticketTakingPlace;

    @Column(name = "contact_information", length = 255)
    private String contactInformation;

    @Column(name = "address", length = 255)
    private String address;

    @Column(name = "level", length = 64)
    private String level;

    @Column(name = "video_url", length = 255)
    private String videoUrl;

    @Column(name = "brief_description", length = 255)
    private String briefDescription;

    @Column(name = "introduction", length = 1024)
    private String introduction;

    @Column(name = "traffic_guide", length = 1024)
    private String trafficGuide;

    @Column(name = "buy_ticket_notes", length = 1024)
    private String buyTicketNotes;

    @Column(name = "characteristic_shopping", length = 1024)
    private String characteristicShopping;

    @Column(name = "specialty_food", length = 1024)
    private String specialtyFood;

    @Column(name = "hide")
    private Boolean hide;

    @Column(name = "recommend")
    private Boolean recommend;

    @Column(name = "sort")
    private Integer sort;

    public String getOpeningTime() {
        return openingTime;
    }

    public void setOpeningTime(String openingTime) {
        this.openingTime = openingTime;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getTicketTakingPlace() {
        return ticketTakingPlace;
    }

    public void setTicketTakingPlace(String ticketTakingPlace) {
        this.ticketTakingPlace = ticketTakingPlace;
    }

    public String getContactInformation() {
        return contactInformation;
    }

    public void setContactInformation(String contactInformation) {
        this.contactInformation = contactInformation;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
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

    public String getBuyTicketNotes() {
        return buyTicketNotes;
    }

    public void setBuyTicketNotes(String buyTicketNotes) {
        this.buyTicketNotes = buyTicketNotes;
    }

    public String getCharacteristicShopping() {
        return characteristicShopping;
    }

    public void setCharacteristicShopping(String characteristicShopping) {
        this.characteristicShopping = characteristicShopping;
    }

    public String getSpecialtyFood() {
        return specialtyFood;
    }

    public void setSpecialtyFood(String specialtyFood) {
        this.specialtyFood = specialtyFood;
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

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}
