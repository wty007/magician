package org.terry.magician.domain;

import javax.persistence.*;

/**
 * @author Terry
 */
@Entity
@Table(name = "dict_many_to_many")
public class DictManyToMany extends IDEntity {

    @ManyToOne
    @JoinColumn(name = "dict_id")
    private Dict dict;

    @Column(name = "source_id", length = 64)
    private String sourceId;

    @Column(name = "sort")
    private Integer sort;

    public Dict getDict() {
        return dict;
    }

    public void setDict(Dict dict) {
        this.dict = dict;
    }

    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}
