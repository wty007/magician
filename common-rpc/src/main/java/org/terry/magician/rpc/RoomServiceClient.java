package org.terry.magician.rpc;

import org.terry.magician.common.service.RoomServiceDefinition;
import org.terry.magician.constant.ServiceConstants;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * @author Terry
 */
@FeignClient(value = ServiceConstants.HOTEL_SERVICE, path = ServiceConstants.HOTEL_SERVICE_PATH_ROOM)
public interface RoomServiceClient extends RoomServiceDefinition {

}
