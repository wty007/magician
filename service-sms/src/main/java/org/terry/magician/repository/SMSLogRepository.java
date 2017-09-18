package org.terry.magician.repository;

import org.terry.magician.domain.SMSLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Terry
 */
@Repository
public interface SMSLogRepository extends JpaRepository<SMSLog, String> {
}
