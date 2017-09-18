package org.terry.magician.common.util;

import java.util.List;

/**
 * @author Terry
 */
public interface JsonService {
    String toJson(Object object);

    Object parseObject(String jsonString);

    <T> T parseObject(String jsonString, Class<T> clazz);

    <T> List<T> parseArray(String jsonString, Class<T> clazz);
}
