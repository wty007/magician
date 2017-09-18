package org.terry.magician.rpc.hystrix;

import org.terry.magician.domain.PageImplWrapper;
import org.terry.magician.domain.SupportServiceCategory;
import org.terry.magician.rpc.SupportServiceCategoryServiceClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Terry
 */
@Service
public class HystrixSupportServiceCategoryServiceClient implements SupportServiceCategoryServiceClient {

    @Autowired
    private SupportServiceCategoryServiceClient supportServiceCategoryServiceClient;

    @Override
    @HystrixCommand(fallbackMethod = "deleteFallBackCall")
    public SupportServiceCategory deleteById(String id) {
        return supportServiceCategoryServiceClient.deleteById(id);
    }

    @Override
    @HystrixCommand(fallbackMethod = "saveFallBackCall")
    public SupportServiceCategory save(String dtoJson) {
        return supportServiceCategoryServiceClient.save(dtoJson);
    }

    @Override
    @HystrixCommand(fallbackMethod = "getByIdFallBackCall")
    public SupportServiceCategory getById(String id) {
        return supportServiceCategoryServiceClient.getById(id);
    }

    @Override
    @HystrixCommand(fallbackMethod = "getPageFallBackCall")
    public PageImplWrapper<SupportServiceCategory> getPage(Integer page, Integer size, List<String> sort) {
        return supportServiceCategoryServiceClient.getPage(page, size, sort);
    }

    @Override
    @HystrixCommand(fallbackMethod = "getListFallBackCall")
    public List<SupportServiceCategory> getList() {
        return supportServiceCategoryServiceClient.getList();
    }

    public SupportServiceCategory deleteFallBackCall(String id) {
        return null;
    }

    public SupportServiceCategory getByIdFallBackCall(String id) {
        return null;
    }

    public SupportServiceCategory saveFallBackCall(String name) {
        return null;
    }

    public PageImplWrapper<SupportServiceCategory> getPageFallBackCall(Integer page, Integer size, List<String> sort) {
        return null;
    }

    public List<SupportServiceCategory> getListFallBackCall() {
        return null;
    }
}

