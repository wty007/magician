package org.terry.magician.rpc;

import org.terry.magician.common.service.AbstractServiceDefinition;
import org.terry.magician.constant.ServiceConstants;
import org.terry.magician.domain.SupportServiceCategory;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * @author Terry
 */
@FeignClient(value = ServiceConstants.HOTEL_SERVICE, path = ServiceConstants.PATH_SERVICE_CATEGORY)
public interface SupportServiceCategoryServiceClient extends AbstractServiceDefinition<SupportServiceCategory, String> {

}
