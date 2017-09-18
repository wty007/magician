package org.terry.magician.common.util;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Terry
 */
@Service
public class JsonServiceFastJsonImpl implements JsonService {
    
    @Override
    public String toJson(Object object) {
        return JSONObject.toJSON(object).toString();
    }

    @Override
    public Object parseObject(String jsonString) {
        return JSONObject.parse(jsonString);
    }

    @Override
    public <T> T parseObject(String jsonString, Class<T> clazz) {
        return JSONObject.parseObject(jsonString, clazz);
    }

    @Override
    public <T> List<T> parseArray(String jsonString, Class<T> clazz) {
        return JSONObject.parseArray(jsonString, clazz);
    }
}
