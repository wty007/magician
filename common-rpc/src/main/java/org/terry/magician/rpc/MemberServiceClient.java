package org.terry.magician.rpc;

import org.terry.magician.common.service.MemberServiceDefinition;
import org.terry.magician.constant.ServiceConstants;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * @author Terry
 */
@FeignClient(value = ServiceConstants.MEMBER_SERVICE)
public interface MemberServiceClient extends MemberServiceDefinition {

}
