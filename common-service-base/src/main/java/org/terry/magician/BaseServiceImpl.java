package org.terry.magician;

import org.terry.magician.domain.IDEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

/**
 * @author Terry
 */
@Transactional
public abstract class BaseServiceImpl<T> implements BaseService<T> {

    private static Sort getSort(List<String> sorts) {
        List<Sort.Order> orderList = new ArrayList<Sort.Order>();

        for (int i = 0; i < sorts.size() - 1; i++) {
            String sort = sorts.get(i);
            if (sort.split(",").length < 2 && isAscOrDesc(sorts.get(i + 1))) {
                sorts.set(i, sorts.get(i) + "," + sorts.get(i + 1));
                sorts.remove(i + 1);
                i--;
            }
        }

        System.out.println(sorts);

        for (String sort : sorts) {

            Sort.Order order = null;
            final String[] split = sort.split(",");
            if (split.length < 2) {
                order = new Sort.Order(sort);
            } else {
                order = new Sort.Order(getDirection(split[1]), split[0]);
            }

            orderList.add(order);
        }

        return new Sort(orderList);

    }

    private static boolean isAscOrDesc(String string) {
        final String lowerCase = string.toLowerCase();
        return lowerCase.equals("asc") || lowerCase.equals("desc");
    }

    private static Sort.Direction getDirection(String direction) {
        if (StringUtils.isEmpty(direction)) {
            return Sort.Direction.ASC;
        }

        return Sort.Direction.fromString(direction);

    }

    abstract protected JpaRepository<T, String> getRepository();

    @Override
    public void delete(Collection<T> entities) {
        getRepository().delete(entities);
    }

    @Override
    public T save(T entity) {

        IDEntity idEntity = (IDEntity) entity;

        if (StringUtils.isEmpty(idEntity.getId())) {
            idEntity.setId(UUID.randomUUID().toString().replace("-", ""));
        }

        return getRepository().save((T) idEntity);
    }

    @Override
    public void delete(String id) {
        getRepository().delete(id);
    }

    @Override
    public void delete(T entity) {
        getRepository().delete(entity);
    }

    @Override
    public T getById(String id) {
        return getRepository().findOne(id);
    }

    @Override
    public List<T> getList() {
        return getRepository().findAll();
    }

    @Override
    public Page<T> getPage(Integer page, Integer size, List<String> sorts) {
        PageRequest pageRequest;
        if (CollectionUtils.isEmpty(sorts)) {
            pageRequest = new PageRequest(page, size);
        } else {
            pageRequest = new PageRequest(page, size, getSort(sorts));
        }
        return getRepository().findAll(pageRequest);
    }

}
