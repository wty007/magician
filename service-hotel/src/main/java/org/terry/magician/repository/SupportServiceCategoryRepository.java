package org.terry.magician.repository;

import org.terry.magician.domain.SupportServiceCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Terry
 */
@Repository
public interface SupportServiceCategoryRepository extends JpaRepository<SupportServiceCategory, String> {
}
