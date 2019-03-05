package com.wind.form.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 表单记录表
 */
public class Record implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
    * 主键id
    */
    private Long id;
    /**
    * 表单id
    */
    private Long formId;
    /**
    * 表单结果
    */
    private String value;
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
    public Long getFormId () {
        return this.formId;
    }

    public void setFormId(Long formId) {
        this.formId = formId;
    }
    public String getValue () {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
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

    public void copy(Record record) {
        this.id = record.id;
        this.formId = record.formId;
        this.value = record.value;
        this.createTime = record.createTime;
        this.updateTime = record.updateTime;
    }

}