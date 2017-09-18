package org.terry.magician.repository;

import org.terry.magician.domain.LineOrderVisitor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Terry
 */
@Repository
public interface LineOrderVisitorRepository extends JpaRepository<LineOrderVisitor, String> {
    List<LineOrderVisitor> findByOrderId(String lineOrderId);
}
