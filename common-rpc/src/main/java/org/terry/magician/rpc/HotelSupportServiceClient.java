package org.terry.magician.rpc;

import org.terry.magician.common.service.HotelSupportServiceDefinition;
import org.terry.magician.constant.ServiceConstants;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * @author Terry
 */
@FeignClient(value = ServiceConstants.HOTEL_SERVICE, path = ServiceConstants.PATH_HOTEL_SUPPORT_SERVICE)
public interface HotelSupportServiceClient extends HotelSupportServiceDefinition {

}
