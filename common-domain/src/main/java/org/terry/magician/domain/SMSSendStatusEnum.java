package org.terry.magician.domain;

/**
 * 短信发送状态
 *
 * @author Terry
 */
public enum SMSSendStatusEnum {

    SUCCESS("成功", 0),
    ERROR("失败", -1);

    private String name;
    private Integer id;

    SMSSendStatusEnum(String name, Integer id) {
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
