package org.terry.magician.rpc;

import org.terry.magician.common.service.LineServiceDefinition;
import org.terry.magician.constant.ServiceConstants;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * @author Terry
 */
@FeignClient(ServiceConstants.LINE_SERVICE)
public interface LineServiceClient extends LineServiceDefinition {

}
