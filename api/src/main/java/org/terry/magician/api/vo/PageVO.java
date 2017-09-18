package org.terry.magician.api.vo;

import org.terry.magician.domain.PageImplWrapper;

import java.util.Collection;

/**
 * @author Terry
 */
public class PageVO<T> extends BaseVO {

    /**
     * 是否还有更多
     */
    private Boolean hasMore;

    /**
     * 内容
     */
    private Collection<T> content;

    public PageVO(Collection<T> content, boolean hasMore) {
        this.content = content;
        this.hasMore = hasMore;
    }

    public PageVO(PageImplWrapper<T> page) {
        this(page.getContent(), !page.isLast());
    }

    public Boolean getHasMore() {
        return hasMore;
    }

    public void setHasMore(Boolean hasMore) {
        this.hasMore = hasMore;
    }

    public Collection<T> getContent() {
        return content;
    }

    public void setContent(Collection<T> content) {
        this.content = content;
    }
}
