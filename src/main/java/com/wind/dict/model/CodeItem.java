package com.wind.dict.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 */
public class CodeItem implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
    * 
    */
    private Long id;
    /**
    * 所属代码集code
    */
    private String codeSet;
    /**
    * 上级代码code
    */
    private String parentCode;
    /**
    * 代码名称
    */
    private String codeName;
    /**
    * 代码值
    */
    private String codeValue;
    /**
    * 汉语拼音（全拼）
    */
    private String zhSpell;
    /**
    * 汉语拼音（简拼）
    */
    private String zhSpellShort;
    /**
    * 顺序号
    */
    private Integer sn;
    /**
    * 说明
    */
    private String remark;
    /**
    * 状态: 1启用; 0 停用
    */
    private Integer status;
    /**
    * 创建人
    */
    private String createUser;
    /**
    * 最近修改人
    */
    private String updateUser;
    /**
    * 当条记录的创建时间
    */
    private Date createTime;
    /**
    * 更新时间
    */
    private Date updateTime;
    /**
    * 生成服务端js时，生成到指定的N个js文件中，该字段是多个js文件名，以逗号分隔
    */
    private String belong;


    public Long getId () {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getCodeSet () {
        return this.codeSet;
    }

    public void setCodeSet(String codeSet) {
        this.codeSet = codeSet;
    }
    public String getParentCode () {
        return this.parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }
    public String getCodeName () {
        return this.codeName;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }
    public String getCodeValue () {
        return this.codeValue;
    }

    public void setCodeValue(String codeValue) {
        this.codeValue = codeValue;
    }
    public String getZhSpell () {
        return this.zhSpell;
    }

    public void setZhSpell(String zhSpell) {
        this.zhSpell = zhSpell;
    }
    public String getZhSpellShort () {
        return this.zhSpellShort;
    }

    public void setZhSpellShort(String zhSpellShort) {
        this.zhSpellShort = zhSpellShort;
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
    public String getCreateUser () {
        return this.createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }
    public String getUpdateUser () {
        return this.updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
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
    public String getBelong () {
        return this.belong;
    }

    public void setBelong(String belong) {
        this.belong = belong;
    }

    public void copy(CodeItem codeItem) {
        this.id = codeItem.id;
        this.codeSet = codeItem.codeSet;
        this.parentCode = codeItem.parentCode;
        this.codeName = codeItem.codeName;
        this.codeValue = codeItem.codeValue;
        this.zhSpell = codeItem.zhSpell;
        this.zhSpellShort = codeItem.zhSpellShort;
        this.sn = codeItem.sn;
        this.remark = codeItem.remark;
        this.status = codeItem.status;
        this.createUser = codeItem.createUser;
        this.updateUser = codeItem.updateUser;
        this.createTime = codeItem.createTime;
        this.updateTime = codeItem.updateTime;
        this.belong = codeItem.belong;
    }

}