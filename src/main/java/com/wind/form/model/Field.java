package com.wind.form.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 表单属性信息表
 */
public class Field implements Serializable {

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
    * 表单属性名称
    */
    private String name;
    /**
    * 是否必填：1、是；0、否
    */
    private String isMust;
    /**
    * 类型：1、input_text
    */
    private Integer type;
    /**
    * css 样式
    */
    private String cssClass;
    /**
    * 是否显示：1、显示；0、隐藏
    */
    private Integer isShow;
    /**
    * 默认值
    */
    private String defaultVal;
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
    public String getName () {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getIsMust () {
        return this.isMust;
    }

    public void setIsMust(String isMust) {
        this.isMust = isMust;
    }
    public Integer getType () {
        return this.type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
    public String getCssClass () {
        return this.cssClass;
    }

    public void setCssClass(String cssClass) {
        this.cssClass = cssClass;
    }
    public Integer getIsShow () {
        return this.isShow;
    }

    public void setIsShow(Integer isShow) {
        this.isShow = isShow;
    }
    public String getDefaultVal () {
        return this.defaultVal;
    }

    public void setDefaultVal(String defaultVal) {
        this.defaultVal = defaultVal;
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

    public void copy(Field field) {
        this.id = field.id;
        this.formId = field.formId;
        this.name = field.name;
        this.isMust = field.isMust;
        this.type = field.type;
        this.cssClass = field.cssClass;
        this.isShow = field.isShow;
        this.defaultVal = field.defaultVal;
        this.createTime = field.createTime;
        this.updateTime = field.updateTime;
    }

}