package org.terry.magician.api.vo;

/**
 * @author Terry
 */
public class MemberIndexVO extends BaseVO {

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 手机号
     */
    private String mobilePhone;

    /**
     * 性别
     */
    private String sex;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 所有订单数量
     */
    private Integer orderCount;

    /**
     * 未支付订单数量
     */
    private Integer waitPayOrderCount;

    /**
     * 已经完成的订单数量
     */
    private Integer completedOrderCount;

    /**
     * 已取消订单数量
     */
    private Integer canceledOrderCount;

    /**
     * 邮箱地址
     */
    private String email;

    /**
     * 身份证号
     */
    private String idCard;

    /**
     * 邮政编码
     */
    private String zipCode;

    /**
     * 地址
     */
    private String address;

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Integer getOrderCount() {
        return orderCount;
    }

    public void setOrderCount(Integer orderCount) {
        this.orderCount = orderCount;
    }

    public Integer getWaitPayOrderCount() {
        return waitPayOrderCount;
    }

    public void setWaitPayOrderCount(Integer waitPayOrderCount) {
        this.waitPayOrderCount = waitPayOrderCount;
    }

    public Integer getCompletedOrderCount() {
        return completedOrderCount;
    }

    public void setCompletedOrderCount(Integer completedOrderCount) {
        this.completedOrderCount = completedOrderCount;
    }

    public Integer getCanceledOrderCount() {
        return canceledOrderCount;
    }

    public void setCanceledOrderCount(Integer canceledOrderCount) {
        this.canceledOrderCount = canceledOrderCount;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
