package org.terry.magician.repository;

import org.terry.magician.domain.VerifyCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Terry
 */
@Repository
public interface VerifyCodeRepository extends JpaRepository<VerifyCode, String> {
    List<VerifyCode> findTop1ByOwnerAndCodeAndTypeAndUsedOrderByCreateTimeDesc(String owner, String code, Integer type, Boolean used);
}
