package com.wind.dict.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 */
public class CodeItem implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
    * 主键id
    */
    private Long id;
    /**
    * 所属namespace
    */
    private Long codeNamespaceId;
    /**
    * 代码集合code
    */
    private String codeSetKey;
    /**
    * key
    */
    private String key;
    /**
    * value
    */
    private String value;
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
    public Long getCodeNamespaceId () {
        return this.codeNamespaceId;
    }

    public void setCodeNamespaceId(Long codeNamespaceId) {
        this.codeNamespaceId = codeNamespaceId;
    }
    public String getCodeSetKey () {
        return this.codeSetKey;
    }

    public void setCodeSetKey(String codeSetKey) {
        this.codeSetKey = codeSetKey;
    }
    public String getKey () {
        return this.key;
    }

    public void setKey(String key) {
        this.key = key;
    }
    public String getValue () {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
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

    public void copy(CodeItem codeItem) {
        this.id = codeItem.id;
        this.codeNamespaceId = codeItem.codeNamespaceId;
        this.codeSetKey = codeItem.codeSetKey;
        this.key = codeItem.key;
        this.value = codeItem.value;
        this.sn = codeItem.sn;
        this.remark = codeItem.remark;
        this.status = codeItem.status;
        this.createAccountId = codeItem.createAccountId;
        this.updateAccountId = codeItem.updateAccountId;
        this.createTime = codeItem.createTime;
        this.updateTime = codeItem.updateTime;
    }

}