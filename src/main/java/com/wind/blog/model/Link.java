package com.wind.blog.model;

public class Link {
    private Long id;

    private Integer from;

    private String url;

    private Integer isParse;

    private Long blogId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getFrom() {
        return from;
    }

    public void setFrom(Integer from) {
        this.from = from;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public Integer getIsParse() {
        return isParse;
    }

    public void setIsParse(Integer isParse) {
        this.isParse = isParse;
    }

    public Long getBlogId() {
        return blogId;
    }

    public void setBlogId(Long blogId) {
        this.blogId = blogId;
    }
}