package org.terry.magician.rpc.hystrix;

import org.terry.magician.domain.Line;
import org.terry.magician.domain.PageImplWrapper;
import org.terry.magician.rpc.LineServiceClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Terry
 */
@Service
public class HystrixLineServiceClient implements LineServiceClient {

    @Autowired
    private LineServiceClient lineServiceClient;

    @Override
    @HystrixCommand(fallbackMethod = "searchFallBackCall")
    public PageImplWrapper<Line> search(String city, String keyword, Integer page, Integer size) {
        return lineServiceClient.search(city, keyword, page, size);
    }

    public PageImplWrapper<Line> searchFallBackCall(String city, String keyword, Integer page, Integer size) {
        return null;
    }

    @Override
    @HystrixCommand(fallbackMethod = "getRecommendListFallBackCall")
    public List<Line> getRecommendList() {
        return lineServiceClient.getRecommendList();
    }

    public List<Line> getRecommendListFallBackCall() {
        return null;
    }

    @Override
    @HystrixCommand(fallbackMethod = "deleteByIdFallBackCall")
    public Boolean deleteById(String id) {
        return lineServiceClient.deleteById(id);
    }

    @Override
    @HystrixCommand(fallbackMethod = "saveFallBackCall")
    public Line save(String dtoJson) {
        return lineServiceClient.save(dtoJson);
    }

    @Override
    @HystrixCommand(fallbackMethod = "getByIdFallBackCall")
    public Line getById(String id) {
        return lineServiceClient.getById(id);
    }

    @Override
    @HystrixCommand(fallbackMethod = "getPageFallBackCall")
    public PageImplWrapper<Line> getPage(Integer page, Integer size, List<String> sort) {
        return lineServiceClient.getPage(page, size, sort);
    }

    @Override
    @HystrixCommand(fallbackMethod = "getListFallBackCall")
    public List<Line> getList() {
        return lineServiceClient.getList();
    }

    public Boolean deleteByIdFallBackCall(String id) {
        return Boolean.FALSE;
    }

    public Line getByIdFallBackCall(String id) {
        return null;
    }

    public Line saveFallBackCall(String name) {
        return null;
    }

    public PageImplWrapper<Line> getPageFallBackCall(Integer page, Integer size, List<String> sort) {
        return null;
    }

    public List<Line> getListFallBackCall() {
        return null;
    }
}

