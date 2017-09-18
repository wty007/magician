package org.terry.magician.repository;

import org.terry.magician.domain.Dict;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Terry
 */
@Repository
public interface DictRepository extends JpaRepository<Dict, String> {
    List<Dict> findByTypeOrderBySortAsc(String type);
}
