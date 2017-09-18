package org.terry.magician.admin.ui;

import com.google.common.collect.Lists;
import org.terry.magician.common.util.JsonService;
import org.terry.magician.domain.DictManyToMany;
import org.terry.magician.rpc.hystrix.HystrixDictManyToManyServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author Terry
 */
@Controller
@RequestMapping("dict/many")
public class DictManyToManyController {

    @Autowired
    HystrixDictManyToManyServiceClient hystrixDictManyToManyServiceClient;

    @Autowired
    JsonService jsonService;

    @RequestMapping(value = "/findBySourceIdAndDictType", method = RequestMethod.GET)
    @ResponseBody
    public List<DictManyToMany> findBySourceIdAndDictType(@RequestParam("sourceId") String sourceId, @RequestParam("dictType") String dictType) {
        return hystrixDictManyToManyServiceClient.findBySourceIdAndDictType(sourceId, dictType);
    }

    @RequestMapping(value = "/saveBySourceIdAndDictTypeAndDictIds", method = RequestMethod.POST)
    @ResponseBody
    public void saveBySourceIdAndDictTypeAndDictIds(@RequestParam("sourceId") String sourceId,
                                                    @RequestParam("dictType") String dictType,
                                                    @RequestParam(name = "dictIds", required = false) String[] dictIds) {
        hystrixDictManyToManyServiceClient.saveBySourceIdAndDictTypeAndDictIds(sourceId, dictType, dictIds != null && dictIds.length > 0 ? Lists.newArrayList(dictIds) : Lists.<String>newArrayList(""));
    }

}
