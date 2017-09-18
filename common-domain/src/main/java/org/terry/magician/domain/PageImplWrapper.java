package org.terry.magician.domain;

import org.springframework.data.domain.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Terry
 */
public class PageImplWrapper<T> extends PageImpl {

    private long totalElements;
    private int number;
    private int size;
    private boolean isFirst;
    private Sort sort;
    private List<T> content;
    private int totalPages;

    public PageImplWrapper(List<T> content, Pageable pageable, long total) {
        super(content, pageable, total);
    }

    public PageImplWrapper(List<T> content) {
        super(content);
    }

    public PageImplWrapper() {
        this(new ArrayList<T>());
    }

    public PageImplWrapper(Page<T> page) {
        super(page.getContent(), new PageRequest(page.getNumber(), page.getSize()), page.getTotalElements());
        this.content = page.getContent();
        this.size = super.getSize();
        this.totalElements = super.getTotalElements();
        this.number = super.getNumber();
        this.isFirst = super.isFirst();
        this.sort = super.getSort();
        this.totalPages = super.getTotalPages();
    }

    @Override
    public int getTotalPages() {
        return this.totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    @Override
    public long getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(long totalElements) {
        this.totalElements = totalElements;
    }

    @Override
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public boolean isFirst() {
        return isFirst;
    }

    public void setFirst(boolean first) {
        isFirst = first;
    }

    @Override
    public List<T> getContent() {
        return content;
    }

    public void setContent(List<T> content) {
        this.content = content;
    }

    @Override
    public Sort getSort() {
        return sort;
    }

    public void setSort(Sort sort) {
        this.sort = sort;
    }
}
