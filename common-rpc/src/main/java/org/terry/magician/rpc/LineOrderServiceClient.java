package org.terry.magician.rpc;

import org.terry.magician.common.service.LineOrderServiceDefinition;
import org.terry.magician.constant.ServiceConstants;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * @author Terry
 */
@FeignClient(value = ServiceConstants.LINE_SERVICE, path = ServiceConstants.LINE_SERVICE_PATH_ORDER)
public interface LineOrderServiceClient extends LineOrderServiceDefinition {

}
