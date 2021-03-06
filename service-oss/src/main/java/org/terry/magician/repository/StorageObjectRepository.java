package org.terry.magician.repository;

import org.terry.magician.domain.StorageObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Terry
 */
@Repository
public interface StorageObjectRepository extends JpaRepository<StorageObject, String> {
}
