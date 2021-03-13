package com.bin23.entity;

/**
 * 分页类
 */
public class PageBean {
    private int page; //  当前页:及第几页
    private int pageSize; // 每页大小:即每页多少条数据
    private int start;  // 起始点:当前页首条数据

    public PageBean(int page, int pageSize) {
        super();
        this.page = page;
        this.pageSize = pageSize;
    }

    public int getPage() {
        return page;
    }
    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getStart() {
        return (page-1)*pageSize;
    }
}
