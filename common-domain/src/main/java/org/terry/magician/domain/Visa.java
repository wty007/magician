package org.terry.magician.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author Terry
 */
@Entity
@Table(name = "visa")
public class Visa extends IDEntity {

    @Column(name = "name", length = 255)
    private String name;

    /**
     * 签发城市
     */
    @Column(name = "issue_city", length = 64)
    private String issueCity;

    /**
     * 签证类型
     */
    @Column(name = "type", length = 64)
    private String type;

    /**
     * 面试
     */
    @Column(name = "interview", length = 64)
    private String interview;

    /**
     * 签证价格
     */
    @Column(name = "price", length = 64)
    private Double price;

    /**
     * 点评积分
     */
    @Column(name = "comments_score")
    private Integer commentsScore;

    /**
     * 抵用积分
     */
    @Column(name = "can_use_score")
    private Integer canUseScore;

    /**
     * 处理方式
     */
    @Column(name = "process_type")
    private Integer processType;

    /**
     * 签证有效期
     */
    @Column(name = "valid_period", length = 255)
    private String validPeriod;

    /**
     * 办理时长
     */
    @Column(name = "handle_duration", length = 255)
    private String handleDuration;

    /**
     * 最长停留时间
     */
    @Column(name = "maximum_stay_time", length = 255)
    private String maximumStayTime;

    /**
     * 入境次数
     */
    @Column(name = "entry_times", length = 255)
    private String entryTimes;

    /****************************************
     * 所需材料
     ***************************************/

    /**
     * 在职人员
     */
    @Column(name = "serving_officer_materials_needed", length = 1024)
    private String servingOfficerMaterialsNeeded;

    /**
     * 自由职业者
     */
    @Column(name = "freelancer_materials_needed", length = 1024)
    private String freelancerMaterialsNeeded;

    /**
     * 退休人员
     */
    @Column(name = "retiree_materials_needed", length = 1024)
    private String retireeMaterialsNeeded;

    /**
     * 在校学生
     */
    @Column(name = "school_student_materials_needed", length = 1024)
    private String schoolStudentMaterialsNeeded;

    /**
     * 学龄前儿童
     */
    @Column(name = "preschool_children_materials_needed", length = 1024)
    private String preschoolChildrenMaterialsNeeded;

    /**
     * 友情提示
     */
    @Column(name = "friendship_tips", length = 1024)
    private String friendshipTips;

    /**
     * 预定须知
     */
    @Column(name = "booking_notice", length = 1024)
    private String bookingNotice;

    /**
     * 温馨提示
     */
    @Column(name = "tips", length = 1024)
    private String tips;

    /**
     * 签约付款
     */
    @Column(name = "contract_payment", length = 1024)
    private String contractPayment;

    /**
     * 快递费用说明
     */
    @Column(name = "express_fee_description", length = 1024)
    private String expressFeeDescription;

    @Column(name = "hide")
    private Boolean hide;

    @Column(name = "recommend")
    private Boolean recommend;

    @Column(name = "sort")
    private Integer sort;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIssueCity() {
        return issueCity;
    }

    public void setIssueCity(String issueCity) {
        this.issueCity = issueCity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getInterview() {
        return interview;
    }

    public void setInterview(String interview) {
        this.interview = interview;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getCommentsScore() {
        return commentsScore;
    }

    public void setCommentsScore(Integer commentsScore) {
        this.commentsScore = commentsScore;
    }

    public Integer getCanUseScore() {
        return canUseScore;
    }

    public void setCanUseScore(Integer canUseScore) {
        this.canUseScore = canUseScore;
    }

    public Integer getProcessType() {
        return processType;
    }

    public void setProcessType(Integer processType) {
        this.processType = processType;
    }

    public String getValidPeriod() {
        return validPeriod;
    }

    public void setValidPeriod(String validPeriod) {
        this.validPeriod = validPeriod;
    }

    public String getHandleDuration() {
        return handleDuration;
    }

    public void setHandleDuration(String handleDuration) {
        this.handleDuration = handleDuration;
    }

    public String getMaximumStayTime() {
        return maximumStayTime;
    }

    public void setMaximumStayTime(String maximumStayTime) {
        this.maximumStayTime = maximumStayTime;
    }

    public String getEntryTimes() {
        return entryTimes;
    }

    public void setEntryTimes(String entryTimes) {
        this.entryTimes = entryTimes;
    }

    public String getServingOfficerMaterialsNeeded() {
        return servingOfficerMaterialsNeeded;
    }

    public void setServingOfficerMaterialsNeeded(String servingOfficerMaterialsNeeded) {
        this.servingOfficerMaterialsNeeded = servingOfficerMaterialsNeeded;
    }

    public String getFreelancerMaterialsNeeded() {
        return freelancerMaterialsNeeded;
    }

    public void setFreelancerMaterialsNeeded(String freelancerMaterialsNeeded) {
        this.freelancerMaterialsNeeded = freelancerMaterialsNeeded;
    }

    public String getRetireeMaterialsNeeded() {
        return retireeMaterialsNeeded;
    }

    public void setRetireeMaterialsNeeded(String retireeMaterialsNeeded) {
        this.retireeMaterialsNeeded = retireeMaterialsNeeded;
    }

    public String getSchoolStudentMaterialsNeeded() {
        return schoolStudentMaterialsNeeded;
    }

    public void setSchoolStudentMaterialsNeeded(String schoolStudentMaterialsNeeded) {
        this.schoolStudentMaterialsNeeded = schoolStudentMaterialsNeeded;
    }

    public String getPreschoolChildrenMaterialsNeeded() {
        return preschoolChildrenMaterialsNeeded;
    }

    public void setPreschoolChildrenMaterialsNeeded(String preschoolChildrenMaterialsNeeded) {
        this.preschoolChildrenMaterialsNeeded = preschoolChildrenMaterialsNeeded;
    }

    public String getFriendshipTips() {
        return friendshipTips;
    }

    public void setFriendshipTips(String friendshipTips) {
        this.friendshipTips = friendshipTips;
    }

    public String getBookingNotice() {
        return bookingNotice;
    }

    public void setBookingNotice(String bookingNotice) {
        this.bookingNotice = bookingNotice;
    }

    public String getTips() {
        return tips;
    }

    public void setTips(String tips) {
        this.tips = tips;
    }

    public String getContractPayment() {
        return contractPayment;
    }

    public void setContractPayment(String contractPayment) {
        this.contractPayment = contractPayment;
    }

    public String getExpressFeeDescription() {
        return expressFeeDescription;
    }

    public void setExpressFeeDescription(String expressFeeDescription) {
        this.expressFeeDescription = expressFeeDescription;
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
