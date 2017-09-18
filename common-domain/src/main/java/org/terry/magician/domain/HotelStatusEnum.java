package org.terry.magician.domain;

/**
 * @author Terry
 */
public enum HotelStatusEnum {

    A;

    private Integer id;
    private String code;
    private String showName;

    public Integer getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getShowName() {
        return showName;
    }
}
