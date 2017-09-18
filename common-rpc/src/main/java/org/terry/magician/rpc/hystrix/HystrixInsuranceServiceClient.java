package org.terry.magician.rpc.hystrix;

import com.google.common.collect.Lists;
import org.terry.magician.domain.Insurance;
import org.terry.magician.domain.PageImplWrapper;
import org.terry.magician.rpc.InsuranceServiceClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Terry
 */
@Service
public class HystrixInsuranceServiceClient implements InsuranceServiceClient {

    @Autowired
    private InsuranceServiceClient insuranceServiceClient;

    @Override
    @HystrixCommand(fallbackMethod = "deleteFallBackCall")
    public Insurance deleteById(String id) {
        return insuranceServiceClient.deleteById(id);
    }

    @Override
    @HystrixCommand(fallbackMethod = "saveFallBackCall")
    public Insurance save(String dtoJson) {
        return insuranceServiceClient.save(dtoJson);
    }

    @Override
    @HystrixCommand(fallbackMethod = "getByIdFallBackCall")
    public Insurance getById(String id) {
        return insuranceServiceClient.getById(id);
    }

    @Override
    @HystrixCommand(fallbackMethod = "getPageFallBackCall")
    public PageImplWrapper<Insurance> getPage(Integer page, Integer size, List<String> sort) {
        return insuranceServiceClient.getPage(page, size, sort);
    }

    @Override
    @HystrixCommand(fallbackMethod = "getListFallBackCall")
    public List<Insurance> getList() {
        return insuranceServiceClient.getList();
    }

    public Insurance deleteFallBackCall(String id) {
        Insurance insurance = new Insurance();
        insurance.setName("FAILED VISA SERVICE CALL! - FALLING BACK" + id);
        return insurance;
    }

    public Insurance getByIdFallBackCall(String id) {
        Insurance insurance = new Insurance();
        insurance.setName("FAILED VISA SERVICE CALL! - FALLING BACK" + id);
        return insurance;
    }

    public Insurance saveFallBackCall(String name) {
        Insurance insurance = new Insurance();
        insurance.setName("FAILED Insurance SERVICE CALL! - FALLING BACK" + name);
        return insurance;
    }

    public PageImplWrapper<Insurance> getPageFallBackCall(Integer page, Integer size, List<String> sort) {
        final Insurance insurance = new Insurance();
        insurance.setName("请求失败,请确认微服务状态是否正常");
        return new PageImplWrapper<Insurance>(Lists.<Insurance>newArrayList(insurance));
    }

    public List<Insurance> getListFallBackCall() {
        return Lists.newArrayList();
    }
}

