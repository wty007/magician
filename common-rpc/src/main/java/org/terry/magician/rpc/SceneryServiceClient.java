package org.terry.magician.rpc;

import org.terry.magician.common.service.SceneryServiceDefinition;
import org.terry.magician.constant.ServiceConstants;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * @author Terry
 */
@FeignClient(ServiceConstants.SCENERY_SERVICE)
public interface SceneryServiceClient extends SceneryServiceDefinition {

}
