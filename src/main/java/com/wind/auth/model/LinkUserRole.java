package com.wind.auth.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户角色关系表
 */
public class LinkUserRole implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
    * 主键id
    */
    private Long id;
    /**
    * 用户id
    */
    private Long userId;
    /**
    * 角色id
    */
    private Long roleId;
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
    public Long getUserId () {
        return this.userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public Long getRoleId () {
        return this.roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
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

    public void copy(LinkUserRole linkUserRole) {
        this.id = linkUserRole.id;
        this.userId = linkUserRole.userId;
        this.roleId = linkUserRole.roleId;
        this.createTime = linkUserRole.createTime;
        this.updateTime = linkUserRole.updateTime;
    }

}