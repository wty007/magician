package org.terry.magician.api;

/**
 * @author Terry
 */
public interface Constants {

    int TYPE_VERIFY_CODE_ALL = 100;
    //00表示订单未支付，01表示处理中，02表示订单支付成功，03表示订单支付失败，08表示订单不存在
    String ORDER_NOT_PAY = "00";
    String ORDER_IN_PROCESS = "01";
    String ORDER_SUCCESS = "02";
    String ORDER_FAIL = "03";
    String ORDER_NOT_EXISTENT = "08";

    String DEFAULT_PAGE_SIZE = "10";


    String DEFAULT_PAGE_NO = "0";
}
