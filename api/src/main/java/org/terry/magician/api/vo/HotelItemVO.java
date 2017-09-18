package org.terry.magician.api.vo;

/**
 * @author Terry
 */
public class HotelItemVO extends BaseItemVO {

    /**
     * 地址
     */
    private String address;

    /**
     * 级别,例如 一星级
     */
    private String level;

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
