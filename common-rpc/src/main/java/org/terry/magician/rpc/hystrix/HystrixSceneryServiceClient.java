package org.terry.magician.rpc.hystrix;

import org.terry.magician.domain.PageImplWrapper;
import org.terry.magician.domain.Scenery;
import org.terry.magician.rpc.SceneryServiceClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Terry
 */
@Service
public class HystrixSceneryServiceClient implements SceneryServiceClient {

    @Autowired
    private SceneryServiceClient sceneryServiceClient;

    @Override
    @HystrixCommand(fallbackMethod = "searchListFallBackCall")
    public PageImplWrapper<Scenery> search(String city, String keyword, Integer page, Integer size) {
        return sceneryServiceClient.search(city, keyword, page, size);
    }

    public PageImplWrapper<Scenery> searchListFallBackCall(String city, String keyword, Integer page, Integer size) {
        return null;
    }

    @Override
    @HystrixCommand(fallbackMethod = "getRecommendListFallBackCall")
    public List<Scenery> getRecommendList() {
        return sceneryServiceClient.getRecommendList();
    }

    public List<Scenery> getRecommendListFallBackCall() {
        return null;
    }

    @Override
    @HystrixCommand(fallbackMethod = "deleteFallBackCall")
    public Scenery deleteById(String id) {
        return sceneryServiceClient.deleteById(id);
    }

    @Override
    @HystrixCommand(fallbackMethod = "saveFallBackCall")
    public Scenery save(String dtoJson) {
        return sceneryServiceClient.save(dtoJson);
    }

    @Override
    @HystrixCommand(fallbackMethod = "getByIdFallBackCall")
    public Scenery getById(String id) {
        return sceneryServiceClient.getById(id);
    }

    @Override
    @HystrixCommand(fallbackMethod = "getPageFallBackCall")
    public PageImplWrapper<Scenery> getPage(Integer page, Integer size, List<String> sort) {
        return sceneryServiceClient.getPage(page, size, sort);
    }

    @Override
    @HystrixCommand(fallbackMethod = "getListFallBackCall")
    public List<Scenery> getList() {
        return sceneryServiceClient.getList();
    }

    public Scenery deleteFallBackCall(String id) {
        return null;
    }

    public Scenery getByIdFallBackCall(String id) {
        return null;
    }

    public Scenery saveFallBackCall(String name) {
        return null;
    }

    public PageImplWrapper<Scenery> getPageFallBackCall(Integer page, Integer size, List<String> sort) {
        return null;
    }

    public List<Scenery> getListFallBackCall() {
        return null;
    }
}

