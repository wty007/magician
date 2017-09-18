package org.terry.magician.common.service;

import org.terry.magician.domain.DictManyToMany;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author Terry
 */
public interface DictManyToManyServiceDefinition {

    @RequestMapping(value = "findBySourceIdAndDictType")
    List<DictManyToMany> findBySourceIdAndDictType(@RequestParam("sourceId") String sourceId,
                                                   @RequestParam("dictType") String dictType);

    @RequestMapping(value = "saveBySourceIdAndDictTypeAndDictIds")
    void saveBySourceIdAndDictTypeAndDictIds(@RequestParam("sourceId") String sourceId,
                                             @RequestParam("dictType") String dictType,
                                             @RequestParam("dictIds") List<String> dictIds);

}
