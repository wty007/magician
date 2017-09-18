package org.terry.magician.rpc;

import org.terry.magician.common.service.SMSServiceDefinition;
import org.terry.magician.constant.ServiceConstants;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * @author Terry
 */
@FeignClient(ServiceConstants.SMS_SERVICE)
public interface SMSServiceClient extends SMSServiceDefinition {

}
