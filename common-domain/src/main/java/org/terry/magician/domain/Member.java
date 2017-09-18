package org.terry.magician.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Date;

/**
 * @author Terry
 */
@Entity
public class Member extends IDEntity {

    /**
     * token
     */
    @Column(name = "token", length = 64)
    private String token;

    /**
     * 真实姓名
     */
    @Column(name = "real_name", length = 32)
    private String realName;

    /**
     * 所属行业
     */
    @Column(name = "profession", length = 64)
    private String profession;

    /**
     * 教育程度
     */
    @Column(name = "education_level", length = 64)
    private String educationLevel;

    /**
     * 身份证号
     */
    @Column(name = "id_number", length = 32)
    private String idNumber;

    /**
     * 手机号
     */
    @Column(name = "mobile_phone", length = 32)
    private String mobilePhone;

    /**
     * 昵称
     */
    @Column(name = "nick_name", length = 255)
    private String nickName;

    /**
     * 密码
     */
    @JsonIgnore
    @Column(length = 255)
    private String password;

    /**
     * 登陆名
     */
    @Column(name = "login_name", length = 255)
    private String loginName;

    /**
     * 注册时间
     */
    @Column(name = "register_time")
    private Date registerTime;

    @Column(name = "email", length = 128)
    private String email;

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public Date getRegisterTime() {
        return registerTime;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getEducationLevel() {
        return educationLevel;
    }

    public void setEducationLevel(String educationLevel) {
        this.educationLevel = educationLevel;
    }

    @Override
    public String toString() {
        return "Member{" +
                "realName='" + realName + '\'' +
                ", profession='" + profession + '\'' +
                ", educationLevel='" + educationLevel + '\'' +
                ", idNumber='" + idNumber + '\'' +
                ", mobilePhone='" + mobilePhone + '\'' +
                ", nickName='" + nickName + '\'' +
                ", password='" + password + '\'' +
                ", loginName='" + loginName + '\'' +
                ", registerTime=" + registerTime +
                ", email='" + email + '\'' +
                '}';
    }
}
