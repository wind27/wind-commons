package com.wind.auth.model;

import java.io.Serializable;
import java.util.Date;

/**
* 角色权限关系表
*/
public class LinkRolePermission implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
    * 主键id
    */
    private Long id;
    /**
    * 角色id
    */
    private Long roleId;
    /**
    * 权限id
    */
    private Long permissionId;
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
    public Long getRoleId () {
        return this.roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
    public Long getPermissionId () {
        return this.permissionId;
    }

    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
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

    public void copy(LinkRolePermission linkRolePermission) {
        this.id = linkRolePermission.id;
        this.roleId = linkRolePermission.roleId;
        this.permissionId = linkRolePermission.permissionId;
        this.createTime = linkRolePermission.createTime;
        this.updateTime = linkRolePermission.updateTime;
    }

}