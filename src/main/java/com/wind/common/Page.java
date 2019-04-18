package com.wind.common;

/**
 * PageModel
 *
 * @author qianchun
 * @date 2019/1/25
 **/
public class Page {

    /**
     * 分页查询起始下标
     */
    private Integer start;

    /**
     * 分页大小
     */
    private Integer limit;

    /**
     * 当前页
     */
    private Integer pageNo;

    /**
     * 总页数
     */
    private Integer pageTotal;

    /**
     * 总条数
     */
    private Integer total;

    public Page(Integer pageNo, Integer pageSize) {
        // 默认第一页
        if (pageNo < 1) {
            pageNo = 1;
        }

        // 默认每页20条
        if (pageSize == null || pageSize < 0) {
            pageSize = 20;
        }
        this.pageNo = pageNo;
        this.limit = pageSize;
        this.start = (pageNo - 1) * pageSize;
    }

    public Integer getStart() {
        return (this.pageNo - 1) * this.limit;
    }

    public Integer getLimit() {
        return this.limit;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getTotal() {
        if (total == null) {
            return 0;
        }
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
        if (total == null) {
            pageTotal = 1;
        } else {
            pageTotal = ((total - 1) / limit) + 1;
        }
    }

    public Integer getPageTotal() {
        return pageTotal;
    }
}
