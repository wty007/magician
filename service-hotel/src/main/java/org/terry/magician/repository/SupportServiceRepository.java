package org.terry.magician.repository;

import org.terry.magician.domain.SupportService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Terry
 */
@Repository
public interface SupportServiceRepository extends JpaRepository<SupportService, String> {
}
