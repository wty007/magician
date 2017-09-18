package org.terry.magician.common.util;

import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author Terry
 */
@Service
public class IdServiceUUIDImpl implements IdService {

    @Override
    public String newOne() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
