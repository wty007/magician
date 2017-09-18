package org.terry.magician.repository;

import org.terry.magician.domain.LineOrderInsurance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Terry
 */
@Repository
public interface LineOrderInsuranceRepository extends JpaRepository<LineOrderInsurance, String> {
    List<LineOrderInsurance> findByLineOrderId(String orderId);
}
