package com.wind.auth.model;

import java.io.Serializable;
import java.util.Date;

/**
* 
*/
public class Role implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
    * 主键ID
    */
    private Long id;
    /**
    * 角色名称
    */
    private String name;
    /**
    * 状态：1、启用；0、停用
    */
    private Integer status;
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

    public void copy(Role role) {
        this.id = role.id;
        this.name = role.name;
        this.status = role.status;
        this.createTime = role.createTime;
        this.updateTime = role.updateTime;
    }

}