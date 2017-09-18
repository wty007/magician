package org.terry.magician.domain;

/**
 * @author Terry
 */
public enum LineVisitorCertificateTypeEnum {

    ID("身份证", 0),
    PASSPORT("护照", 10),
    OTHER("其他", 99);

    private String name;
    private Integer id;

    LineVisitorCertificateTypeEnum(String name, Integer id) {
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
