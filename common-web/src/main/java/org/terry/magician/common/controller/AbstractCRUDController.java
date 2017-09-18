package org.terry.magician.common.controller;

import org.terry.magician.common.service.AbstractServiceDefinition;
import org.terry.magician.common.util.IdService;
import org.terry.magician.common.util.JsonService;
import org.terry.magician.constant.PageConstants;
import org.terry.magician.domain.IDEntity;
import org.terry.magician.domain.PageImplWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestParam;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Terry
 */
public abstract class AbstractCRUDController<T extends IDEntity, ID extends String> implements AbstractServiceDefinition<T, ID> {

    @Autowired
    private JsonService jsonService;

    @Autowired
    private IdService idService;

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
                order = new Sort.Order(getDirection(split[1]),split[0]);
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

    protected abstract JpaRepository<T, ID> getRepository();

    @Override
    public PageImplWrapper<T> getPage(
            @RequestParam(value = "page", required = false, defaultValue = PageConstants.DEFAULT_PAGE_NUMBER) Integer page,
            @RequestParam(value = "size", required = false, defaultValue = PageConstants.DEFAULT_PAGE_SIZE) Integer size,
            @RequestParam(value = "sort", required = false, defaultValue = "") List<String> sorts) {
        PageRequest pageRequest;
        if (CollectionUtils.isEmpty(sorts)) {
            pageRequest = new PageRequest(page, size);
        } else {
            pageRequest = new PageRequest(page, size, getSort(sorts));
        }
        final Page<T> hotelPage = getRepository().findAll(pageRequest);
        return new PageImplWrapper<T>(hotelPage);
    }

    @Override
    public List<T> getList() {
        return getRepository().findAll();
    }

    @Override
    public T deleteById(@RequestParam("id") ID id) {
        final T entity = getRepository().getOne(id);
        getRepository().delete(entity);
        return entity;
    }

    @Override
    public T getById(@RequestParam("id") ID id) {
        return getRepository().findOne(id);
    }

    @Override
    public T save(@RequestParam("dtoJson") String dtoJson) {

        final java.lang.reflect.Type type = ((ParameterizedType) this.getClass().getGenericSuperclass())
                .getActualTypeArguments()[0];

        T entity = null;
        try {

            entity = (T) jsonService.parseObject(dtoJson, Class.forName(type.getTypeName()));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        if (StringUtils.isEmpty(entity.getId())) {
            entity.setId(idService.newOne());
        }

        getRepository().save(entity);

        return entity;
    }


}
