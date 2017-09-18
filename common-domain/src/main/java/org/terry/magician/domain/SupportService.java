package org.terry.magician.domain;

import javax.persistence.*;

/**
 * @author Terry
 */
@Entity
@Table(name = "support_service")
public class SupportService extends IDEntity {

    @JoinColumn(name = "category_id")
    @ManyToOne
    private SupportServiceCategory category;

    @Column(name = "name", length = 255)
    private String name;

    @Column(name = "sort")
    private Integer sort;

    public SupportServiceCategory getCategory() {
        return category;
    }

    public void setCategory(SupportServiceCategory category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}
