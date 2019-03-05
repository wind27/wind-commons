package com.wind.form.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 表单信息表
 */
public class Form implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
    * 主键id
    */
    private Long id;
    /**
    * 表单名称
    */
    private String name;
    /**
    * 表单css样式
    */
    private String cssClass;
    /**
    * tr css 样式
    */
    private String trCssClass;
    /**
    * td css 样式
    */
    private String tdClass;
    /**
    * 创建时间
    */
    private Date createTime;
    /**
    * 更新时间
    */
    private Date updateTime;


    public Long getId () {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getName () {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getCssClass () {
        return this.cssClass;
    }

    public void setCssClass(String cssClass) {
        this.cssClass = cssClass;
    }
    public String getTrCssClass () {
        return this.trCssClass;
    }

    public void setTrCssClass(String trCssClass) {
        this.trCssClass = trCssClass;
    }
    public String getTdClass () {
        return this.tdClass;
    }

    public void setTdClass(String tdClass) {
        this.tdClass = tdClass;
    }
    public Date getCreateTime () {
        return this.createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    public Date getUpdateTime () {
        return this.updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public void copy(Form form) {
        this.id = form.id;
        this.name = form.name;
        this.cssClass = form.cssClass;
        this.trCssClass = form.trCssClass;
        this.tdClass = form.tdClass;
        this.createTime = form.createTime;
        this.updateTime = form.updateTime;
    }

}