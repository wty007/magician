package org.terry.magician.rpc;

import org.terry.magician.common.service.TicketServiceDefinition;
import org.terry.magician.constant.ServiceConstants;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * @author Terry
 */
@FeignClient(value = ServiceConstants.SCENERY_SERVICE, path = ServiceConstants.SCENERY_SERVICE_PATH_TICKET)
public interface TicketServiceClient extends TicketServiceDefinition {

}
