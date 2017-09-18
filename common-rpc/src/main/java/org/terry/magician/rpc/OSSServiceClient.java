package org.terry.magician.rpc;

import org.terry.magician.common.service.AbstractServiceDefinition;
import org.terry.magician.constant.ServiceConstants;
import org.terry.magician.domain.StorageObject;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * Created by Administrator on 2017/7/26.
 */
@FeignClient(ServiceConstants.OSS_SERVICE)
public interface OSSServiceClient extends AbstractServiceDefinition<StorageObject, String> {
}
