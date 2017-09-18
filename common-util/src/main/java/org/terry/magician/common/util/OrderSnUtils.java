package org.terry.magician.common.util;

import com.google.common.collect.Sets;
import org.apache.commons.lang.math.RandomUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

/**
 * @author Terry
 */
public class OrderSnUtils {

    private static final String ORDER_SN_PREFIX_ROOM = "R";
    private static final String ORDER_SN_PREFIX_TICKET = "T";
    private static final String ORDER_SN_PREFIX_LINE = "L";
    private static Set<String> snList = Sets.newConcurrentHashSet();

    public static String createRoomOrderSn() {
        return ORDER_SN_PREFIX_ROOM +
                createSn();
    }

    private static String createSn() {

        String sn;
        while (true) {
            sn = getYyyyMMddHHmmss().substring(2)
                    + getRandomString(3);
            if (!snList.contains(sn)) {
                break;
            }
        }
        snList.add(sn);
        return sn;
    }

    public static String createLineOrderSn() {
        return ORDER_SN_PREFIX_LINE +
                getYyyyMMddHHmmss().substring(2) +
                getRandomString(3);
    }

    public static String createTicketOrderSn() {
        return ORDER_SN_PREFIX_TICKET +
                getYyyyMMddHHmmss().substring(2) +
                getRandomString(3);
    }

    private static String getRandomString(int length) {
        final String string = "000" + Integer.toString(RandomUtils.nextInt(1000));
        return string.substring(string.length() - 3);
    }

    private static String getTimeMillLast(int length) {

        String longString = Long.toString(new Date().getTime());

        return longString.substring(13 - length);

    }

    private static String getYyyyMMddHHmmss() {
        return new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
    }

    public static boolean isLineOrderSn(String orderSn) {
        return orderSn.startsWith(ORDER_SN_PREFIX_LINE);
    }

    public static boolean isTicketOrderSn(String orderSn) {
        return orderSn.startsWith(ORDER_SN_PREFIX_TICKET);
    }

    public static boolean isRoomOrderSn(String orderSn) {
        return orderSn.startsWith(ORDER_SN_PREFIX_ROOM);
    }
}
