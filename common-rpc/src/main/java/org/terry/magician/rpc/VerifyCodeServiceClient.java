package org.terry.magician.rpc;

import org.terry.magician.common.service.VerifyCodeServiceDefinition;
import org.terry.magician.constant.ServiceConstants;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * @author Terry
 */
@FeignClient(ServiceConstants.VERIFY_CODE_SERVICE)
public interface VerifyCodeServiceClient extends VerifyCodeServiceDefinition {

}
