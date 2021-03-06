package com.wind.auth.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 权限表
 */
public class Permission implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
    * 主键id
    */
    private Long id;
    /**
    * 权限名称
    */
    private String name;
    /**
    * 权限值
    */
    private String value;
    /**
    * 状态：1、启用；0、停用
    */
    private Integer status;
    /**
    * ????
    */
    private Date createTime;
    /**
    * ????
    */
    private Date updateTime;
    /**
    * parent_id
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
    public String getValue () {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }
    public Integer getStatus () {
        return this.status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    public void copy(Permission permission) {
        this.id = permission.id;
        this.name = permission.name;
        this.value = permission.value;
        this.status = permission.status;
        this.createTime = permission.createTime;
        this.updateTime = permission.updateTime;
        this.parentId = permission.parentId;
    }

}