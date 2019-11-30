package com.wind.dict.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 */
public class CodeNamespace implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
    * 主键id
    */
    private Long id;
    /**
    * 名称
    */
    private String name;
    /**
    * 顺序号
    */
    private Integer sn;
    /**
    * 说明
    */
    private String remark;
    /**
    * 状态 1 启用 0 停用
    */
    private Integer status;
    /**
    * 创建用户
    */
    private String createAccountId;
    /**
    * 更新用户
    */
    private String updateAccountId;
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
    public Integer getSn () {
        return this.sn;
    }

    public void setSn(Integer sn) {
        this.sn = sn;
    }
    public String getRemark () {
        return this.remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
    public Integer getStatus () {
        return this.status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
    public String getCreateAccountId () {
        return this.createAccountId;
    }

    public void setCreateAccountId(String createAccountId) {
        this.createAccountId = createAccountId;
    }
    public String getUpdateAccountId () {
        return this.updateAccountId;
    }

    public void setUpdateAccountId(String updateAccountId) {
        this.updateAccountId = updateAccountId;
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

    public void copy(CodeNamespace codeNamespace) {
        this.id = codeNamespace.id;
        this.name = codeNamespace.name;
        this.sn = codeNamespace.sn;
        this.remark = codeNamespace.remark;
        this.status = codeNamespace.status;
        this.createAccountId = codeNamespace.createAccountId;
        this.updateAccountId = codeNamespace.updateAccountId;
        this.createTime = codeNamespace.createTime;
        this.updateTime = codeNamespace.updateTime;
    }

}