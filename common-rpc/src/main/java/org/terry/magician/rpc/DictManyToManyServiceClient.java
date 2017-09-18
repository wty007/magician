package org.terry.magician.rpc;

import org.terry.magician.common.service.DictManyToManyServiceDefinition;
import org.terry.magician.constant.ServiceConstants;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * @author Terry
 */
@FeignClient(value = ServiceConstants.DICT_SERVICE, path = ServiceConstants.DICT_SERVICE_PATH_MANY_TO_MANY)
public interface DictManyToManyServiceClient extends DictManyToManyServiceDefinition {
}
