package org.terry.magician.controller;

import org.terry.magician.common.controller.AbstractCRUDController;
import org.terry.magician.domain.StorageObject;
import org.terry.magician.repository.StorageObjectRepository;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Terry
 */
@RefreshScope
@Api
@RestController
public class StorageObjectController extends AbstractCRUDController<StorageObject, String> {

    @Autowired
    StorageObjectRepository storageObjectRepository;

    @Override
    protected JpaRepository<StorageObject, String> getRepository() {
        return storageObjectRepository;
    }
}
