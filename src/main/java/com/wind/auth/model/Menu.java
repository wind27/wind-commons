package com.wind.auth.model;

import java.io.Serializable;
import java.util.Date;

/**
* 
*/
public class Menu implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
    * 主键
    */
    private Long id;
    /**
    * 名称
    */
    private String name;
    /**
    * 状态：1、启用；0、停用
    */
    private Integer status;
    /**
    * 应用id
    */
    private Long appId;
    /**
    * 菜单访问url
    */
    private String url;
    /**
    * 创建时间
    */
    private Date createTime;
    /**
    * 更新时间
    */
    private Date updateTime;
    /**
    * 上一级目录（根目录为0）
    */
    private Long parentId;


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
    public Integer getStatus () {
        return this.status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
    public Long getAppId () {
        return this.appId;
    }

    public void setAppId(Long appId) {
        this.appId = appId;
    }
    public String getUrl () {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
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
    public Long getParentId () {
        return this.parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public void copy(Menu menu) {
        this.id = menu.id;
        this.name = menu.name;
        this.status = menu.status;
        this.appId = menu.appId;
        this.url = menu.url;
        this.createTime = menu.createTime;
        this.updateTime = menu.updateTime;
        this.parentId = menu.parentId;
    }

}