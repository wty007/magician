package org.terry.magician.repository;

import org.terry.magician.domain.Line;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Terry
 */
@Repository
public interface LineRepository extends JpaRepository<Line, String> {

    List<Line> findByRecommend(Boolean bool);

    Page<Line> findByNameLike(String keyword, Pageable pageable);
}
