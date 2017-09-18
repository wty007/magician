package org.terry.magician.domain;

/**
 * @author Terry
 */
public enum OrderStatusEnum {

    CANCEL("已取消", -1),
    CREATED("已创建", 0),
    UN_PAID("已支付", 10),
    PAID("已支付", 20),
    UN_PROCESS("未处理", 30),
    PROCESSED("已处理", 40),
    UN_ING("等待出团", 50),
    ING("已出团", 90),
    COMPLETED("已完成", 100);


    private String name;
    private Integer id;

    OrderStatusEnum(String name, Integer id) {
        this.name = name;
        this.id = id;
    }

    public static OrderStatusEnum getById(Integer id) {
        for (OrderStatusEnum status : OrderStatusEnum.values()) {
            if (status.getId().equals(id)) {
                return status;
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }
}
