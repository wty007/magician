package org.terry.magician.rpc;

import org.terry.magician.common.service.HotelServiceDefinition;
import org.terry.magician.constant.ServiceConstants;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * @author Terry
 */
@FeignClient(ServiceConstants.HOTEL_SERVICE)
public interface HotelServiceClient extends HotelServiceDefinition {

}
