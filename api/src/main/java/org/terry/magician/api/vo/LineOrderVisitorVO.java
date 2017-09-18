package org.terry.magician.api.vo;

/**
 * @author Terry
 */
public class LineOrderVisitorVO extends BaseOrderVisitorVO {

    /**
     * 性别
     */
    private Integer sex;

    /**
     * 手机号
     */
    private String mobilePhone;

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }
}
