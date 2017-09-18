package org.terry.magician.repository;

import org.terry.magician.domain.Hotel;
import org.terry.magician.domain.Visa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Terry
 */
@Repository
public interface VisaRepository extends JpaRepository<Visa, String> {
}
