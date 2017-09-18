package org.terry.magician.rpc.hystrix;

import com.google.common.collect.Lists;
import org.terry.magician.domain.PageImplWrapper;
import org.terry.magician.domain.Visa;
import org.terry.magician.rpc.VisaServiceClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Terry
 */
@Service
public class HystrixVisaServiceClient implements VisaServiceClient {

    @Autowired
    private VisaServiceClient visaServiceClient;

    @Override
    @HystrixCommand(fallbackMethod = "deleteFallBackCall")
    public Visa deleteById(String id) {
        return visaServiceClient.deleteById(id);
    }

    @Override
    @HystrixCommand(fallbackMethod = "saveFallBackCall")
    public Visa save(String dtoJson) {
        return visaServiceClient.save(dtoJson);
    }

    @Override
    @HystrixCommand(fallbackMethod = "getByIdFallBackCall")
    public Visa getById(String id) {
        return visaServiceClient.getById(id);
    }

    @Override
    @HystrixCommand(fallbackMethod = "getPageFallBackCall")
    public PageImplWrapper<Visa> getPage(Integer page, Integer size, List<String> sort) {
        return visaServiceClient.getPage(page, size, sort);
    }

    @Override
    @HystrixCommand(fallbackMethod = "getListFallBackCall")
    public List<Visa> getList() {
        return visaServiceClient.getList();
    }

    public Visa deleteFallBackCall(String id) {
        Visa visa = new Visa();
        visa.setName("FAILED VISA SERVICE CALL! - FALLING BACK" + id);
        return visa;
    }

    public Visa getByIdFallBackCall(String id) {
        Visa visa = new Visa();
        visa.setName("FAILED VISA SERVICE CALL! - FALLING BACK" + id);
        return visa;
    }

    public Visa saveFallBackCall(String name) {
        Visa visa = new Visa();
        visa.setName("FAILED Visa SERVICE CALL! - FALLING BACK" + name);
        return visa;
    }

    public PageImplWrapper<Visa> getPageFallBackCall(Integer page, Integer size, List<String> sort) {
        return new PageImplWrapper<Visa>(Lists.<Visa>newArrayList());
    }

    public List<Visa> getListFallBackCall() {
        return Lists.newArrayList();
    }
}

