package org.terry.magician.rpc;

import org.terry.magician.common.service.AbstractServiceDefinition;
import org.terry.magician.constant.ServiceConstants;
import org.terry.magician.domain.Dict;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author Terry
 */
@FeignClient(value = ServiceConstants.DICT_SERVICE)
public interface DictServiceClient extends AbstractServiceDefinition<Dict, String> {

    @RequestMapping(value = "/findByType", method = RequestMethod.GET)
    List<Dict> findByType(@RequestParam("type") String type);

}
