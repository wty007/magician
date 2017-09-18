package org.terry.magician.rpc;

import org.terry.magician.common.service.AbstractServiceDefinition;
import org.terry.magician.constant.ServiceConstants;
import org.terry.magician.domain.Visa;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * @author Terry
 */
@FeignClient(ServiceConstants.VISA_SERVICE)
public interface VisaServiceClient extends AbstractServiceDefinition<Visa, String> {

}
