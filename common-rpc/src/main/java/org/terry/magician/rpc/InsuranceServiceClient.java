package org.terry.magician.rpc;

import org.terry.magician.common.service.AbstractServiceDefinition;
import org.terry.magician.constant.ServiceConstants;
import org.terry.magician.domain.Insurance;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * @author Terry
 */
@FeignClient(value = ServiceConstants.LINE_SERVICE, path = ServiceConstants.LINE_SERVICE_PATH_INSURANCE)
public interface InsuranceServiceClient extends AbstractServiceDefinition<Insurance, String> {

}
