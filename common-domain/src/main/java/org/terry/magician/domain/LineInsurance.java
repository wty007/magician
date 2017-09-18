package org.terry.magician.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author Terry
 */
@Entity
@Table(name = "line_insurance")
public class LineInsurance extends IDEntity {

    /**
     * 线路ID
     */
    @Column(name = "line_id", length = 64)
    private String lineId;

    /**
     * 副标题
     */
    @Column(name = "insurance_id", length = 64)
    private String insuranceId;

    @Column(name = "sort")
    private Integer sort;

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}
