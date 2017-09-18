package org.terry.magician.rpc.hystrix;

import com.google.common.collect.Lists;
import org.terry.magician.domain.PageImplWrapper;
import org.terry.magician.domain.StorageObject;
import org.terry.magician.domain.Visa;
import org.terry.magician.rpc.OSSServiceClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/7/26.
 */
@Service
public class HystrixOSSServiceClient implements OSSServiceClient {
    @Autowired
    private OSSServiceClient ossServiceClient;

    @Override
    @HystrixCommand(fallbackMethod = "getPageFallBackCall")
    public PageImplWrapper<StorageObject> getPage(Integer page, Integer size, List<String> sort) {
        return ossServiceClient.getPage(page, size, sort);
    }

    public PageImplWrapper<StorageObject> getPageFallBackCall(Integer page, Integer size, List<String> sort) {
        return new PageImplWrapper<StorageObject>(Lists.<StorageObject>newArrayList());
    }

    @Override
    @HystrixCommand(fallbackMethod = "getListFallBackCall")
    public List<StorageObject> getList() {
        return ossServiceClient.getList();
    }

    public List<Visa> getListFallBackCall() {
        return Lists.newArrayList();
    }


    @Override
    @HystrixCommand(fallbackMethod = "saveFallBackCall")
    public StorageObject save(String dtoJson) {
        return ossServiceClient.save(dtoJson);
    }

    public StorageObject saveFallBackCall(String dtoJson) {
        StorageObject storageObject = new StorageObject();
        storageObject.setUrl("FAILED Visa SERVICE CALL! - FALLING BACK");
        return storageObject;
    }

    @Override
    @HystrixCommand(fallbackMethod = "deleteFallBackCall")
    public StorageObject deleteById(String id) {
        return ossServiceClient.deleteById(id);
    }

    public StorageObject deleteFallBackCall(String id) {
        StorageObject storageObject = new StorageObject();
        storageObject.setUrl("FAILED Visa SERVICE CALL! - FALLING BACK" + id);
        return storageObject;
    }

    @Override
    @HystrixCommand(fallbackMethod = "getByIdFallBackCall")
    public StorageObject getById(String id) {
        return ossServiceClient.getById(id);
    }

    public StorageObject getByIdFallBackCall(String id) {
        StorageObject storageObject = new StorageObject();
        storageObject.setUrl("FAILED VISA SERVICE CALL! - FALLING BACK" + id);
        return storageObject;
    }
}