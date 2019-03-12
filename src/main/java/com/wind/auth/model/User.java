package com.wind.auth.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户表
 */
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
    * 主键ID
    */
    private Long id;
    /**
    * 用户名
    */
    private String username;
    /**
    * 真实姓名
    */
    private String realname;
    /**
    * 盐值
    */
    private String salt;
    /**
    * 密码
    */
    private String password;
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
    /**
    * 手机号码
    */
    private String mobile;
    /**
    * 身份证
    */
    private String idcard;
    /**
    * 邮箱
    */
    private String email;


    public Long getId () {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getUsername () {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public String getRealname () {
        return this.realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }
    public String getSalt () {
        return this.salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
    public String getPassword () {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
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
    public String getMobile () {
        return this.mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    public String getIdcard () {
        return this.idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }
    public String getEmail () {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void copy(User user) {
        this.id = user.id;
        this.username = user.username;
        this.realname = user.realname;
        this.salt = user.salt;
        this.password = user.password;
        this.status = user.status;
        this.createTime = user.createTime;
        this.updateTime = user.updateTime;
        this.mobile = user.mobile;
        this.idcard = user.idcard;
        this.email = user.email;
    }

}