package org.terry.magician;

import org.springframework.data.domain.Page;

import java.util.Collection;
import java.util.List;

/**
 * @author Terry
 */
public interface BaseService<T> {

    T save(T entity);

    void delete(T entity);

    void delete(String id);

    void delete(Collection<T> entities);

    T getById(String id);

    List<T> getList();

    Page<T> getPage(Integer page, Integer size, List<String> sorts);

}
