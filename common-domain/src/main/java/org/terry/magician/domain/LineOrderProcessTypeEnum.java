package org.terry.magician.domain;

/**
 * @author Terry
 */
public enum LineOrderProcessTypeEnum {

    MANUAL(10, "人工处理"), AUTO(20, "自动处理");

    private Integer id;
    private String name;

    LineOrderProcessTypeEnum(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
