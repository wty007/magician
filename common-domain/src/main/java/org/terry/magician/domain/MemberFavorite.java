package org.terry.magician.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * 用户收藏
 *
 * @author Terry
 */
@Entity
@Table(name = "member_favorite")
public class MemberFavorite extends IDEntity {

    /**
     * 类型
     *
     * @see MemberFavoriteTypeEnum
     */
    @Column(name = "type")
    private Integer type;

    /**
     * id
     */
    @Column(name = "id", length = 32)
    private String id;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
