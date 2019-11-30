package com.wind.dict.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 */
public class CodeSet implements Serializable {

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
    * 名称
    */
    private String name;
    /**
    * key
    */
    private String key;
    /**
    * 说明
    */
    private String remark;
    /**
    * 顺序号
    */
    private Integer sn;
    /**
    * 状态 1 启用 0 停用
    */
    private Integer status;
    /**
    * 是否生成到前端js文件 1 是 0 否
    */
    private Integer isExportJs;
    /**
    * 创建人
    */
    private String createAccountId;
    /**
    * 修改人
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
    public String getName () {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getKey () {
        return this.key;
    }

    public void setKey(String key) {
        this.key = key;
    }
    public String getRemark () {
        return this.remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
    public Integer getSn () {
        return this.sn;
    }

    public void setSn(Integer sn) {
        this.sn = sn;
    }
    public Integer getStatus () {
        return this.status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
    public Integer getIsExportJs () {
        return this.isExportJs;
    }

    public void setIsExportJs(Integer isExportJs) {
        this.isExportJs = isExportJs;
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

    public void copy(CodeSet codeSet) {
        this.id = codeSet.id;
        this.codeNamespaceId = codeSet.codeNamespaceId;
        this.name = codeSet.name;
        this.key = codeSet.key;
        this.remark = codeSet.remark;
        this.sn = codeSet.sn;
        this.status = codeSet.status;
        this.isExportJs = codeSet.isExportJs;
        this.createAccountId = codeSet.createAccountId;
        this.updateAccountId = codeSet.updateAccountId;
        this.createTime = codeSet.createTime;
        this.updateTime = codeSet.updateTime;
    }

}