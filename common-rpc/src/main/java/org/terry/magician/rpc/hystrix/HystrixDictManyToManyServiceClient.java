package org.terry.magician.rpc.hystrix;

import com.google.common.collect.Lists;
import org.terry.magician.domain.DictManyToMany;
import org.terry.magician.rpc.DictManyToManyServiceClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Terry
 */
@Service
public class HystrixDictManyToManyServiceClient implements DictManyToManyServiceClient {

    @Autowired
    private DictManyToManyServiceClient dictManyToManyServiceClient;

    @Override
    @HystrixCommand(fallbackMethod = "findBySourceIdAndDictTypeFallBackCall")
    public List<DictManyToMany> findBySourceIdAndDictType(String sourceId, String dictType) {
        return dictManyToManyServiceClient.findBySourceIdAndDictType(sourceId, dictType);
    }

    @Override
    @HystrixCommand(fallbackMethod = "saveBySourceIdAndDictTypeAndDictIdsFallBackCall")
    public void saveBySourceIdAndDictTypeAndDictIds(String sourceId, String dictType, List<String> dictIds) {
        dictManyToManyServiceClient.saveBySourceIdAndDictTypeAndDictIds(sourceId, dictType, dictIds);
    }

    public void saveBySourceIdAndDictTypeAndDictIdsFallBackCall(
            String sourceId, String dictType, List<String> dictIds) {
    }

    public List<DictManyToMany> findBySourceIdAndDictTypeFallBackCall(String sourceId, String dictType) {
        return Lists.newArrayList();
    }
}

