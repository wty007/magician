package org.terry.magician.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author Terry
 */
@Entity
@Table(name = "dict")
public class Dict extends IDEntity {

    @Column(name = "name", length = 255)
    private String name;

    @Column(name = "value", length = 255)
    private String value;

    @Column(name = "sort")
    private Integer sort;

    @Column(name = "type", length = 255)
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
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
