package com.wind.common;

/**
 * PageModel
 *
 * @author qianchun
 * @date 2019/1/25
 **/
public class Page {

    private Integer pageNum;

    private Integer pageSize;

    public Page(Integer pageNum, Integer pageSize) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
    }

    public Integer getStart() {
        return (this.pageNum - 1) * this.pageSize;
    }

    public Integer getLimit() {
        return pageSize;
    }
}
