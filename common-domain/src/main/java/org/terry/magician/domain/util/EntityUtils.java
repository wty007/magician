package org.terry.magician.domain.util;

import org.terry.magician.domain.IDEntity;
import org.springframework.util.StringUtils;

import java.util.UUID;

/**
 * @author Terry
 */
public class EntityUtils {

    public static void preSave(IDEntity entity) {
        if (StringUtils.isEmpty(entity.getId())) {
            entity.setId(UUID.randomUUID().toString().replace("-", ""));
        }
    }
}
