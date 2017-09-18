package org.terry.magician.repository;

import org.terry.magician.domain.Insurance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Terry
 */
@Repository
public interface InsuranceRepository extends JpaRepository<Insurance, String> {
}
