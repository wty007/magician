package org.terry.magician.domain;

/**
 * @author Terry
 */
public enum LineVisitorTypeEnum {

    ADULT("成人", 0),
    CHILD("儿童", 10);

    private String name;
    private Integer id;

    LineVisitorTypeEnum(String name, Integer id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Integer getCode() {
        return id;
    }
}
