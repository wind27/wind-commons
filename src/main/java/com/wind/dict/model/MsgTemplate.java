package com.wind.dict.model;

import java.io.Serializable;
import java.util.Date;

/**
 * æ¨¡æ¿ç®¡ç†(çŸ­ä¿¡,é‚®ä»¶,ç«™å†…ä¿¡,é€šçŸ¥)
 */
public class MsgTemplate implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
    * ä¸»é”®
    */
    private Long id;
    /**
    * æ¨¡æ¿ç±»åž‹:1ã€sms,2ã€email,3ã€ ç«™å†…æ¶ˆæ¯,4ã€app-notice
    */
    private Integer templateType;
    /**
    * æ¨¡æ¿æ ‡è¯†
    */
    private String templateId;
    /**
    * æ¨¡æ¿åç§°
    */
    private String templateName;
    /**
    * æ¨¡æ¿ç‰ˆæœ¬:å¦‚1,2,3,4
    */
    private Integer templateVersion;
    /**
    * æ¶ˆæ¯æ ‡é¢˜
    */
    private String msgTitle;
    /**
    * æ¶ˆæ¯å†…å®¹
    */
    private String msgContent;
    /**
    * å‘é€äººid
    */
    private Long senderId;
    /**
    * å‘é€äººåå­—
    */
    private String senderName;
    /**
    * çŠ¶æ€:0ã€ç¦ç”¨,1ã€å¯ç”¨;
    */
    private Integer status;
    /**
    * è¯·æ±‚æ–¹ç³»ç»Ÿæ ‡è¯†(å¹³å°æ ‡è¯†)
    */
    private String reqSysCode;
    /**
    * åˆ›å»ºäººUID
    */
    private Long createUserId;
    /**
    * åˆ›å»ºäºº
    */
    private String createUserName;
    /**
    * æœ€åŽæ›´æ–°äººUID
    */
    private Long updateUserId;
    /**
    * æœ€åŽæ›´æ–°äºº
    */
    private String updateUserName;
    /**
    * æ¨¡æ¿å‚æ•°é…ç½®
    */
    private String templateConfig;
    /**
    * æ¶ˆæ¯é“¾æŽ¥ wechatä½¿ç”¨
    */
    private String msgLink;
    /**
    * åˆ›å»ºæ—¶é—´
    */
    private Date createTime;
    /**
    * æ›´æ–°æ—¶é—´
    */
    private Date updateTime;


    public Long getId () {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Integer getTemplateType () {
        return this.templateType;
    }

    public void setTemplateType(Integer templateType) {
        this.templateType = templateType;
    }
    public String getTemplateId () {
        return this.templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }
    public String getTemplateName () {
        return this.templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }
    public Integer getTemplateVersion () {
        return this.templateVersion;
    }

    public void setTemplateVersion(Integer templateVersion) {
        this.templateVersion = templateVersion;
    }
    public String getMsgTitle () {
        return this.msgTitle;
    }

    public void setMsgTitle(String msgTitle) {
        this.msgTitle = msgTitle;
    }
    public String getMsgContent () {
        return this.msgContent;
    }

    public void setMsgContent(String msgContent) {
        this.msgContent = msgContent;
    }
    public Long getSenderId () {
        return this.senderId;
    }

    public void setSenderId(Long senderId) {
        this.senderId = senderId;
    }
    public String getSenderName () {
        return this.senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }
    public Integer getStatus () {
        return this.status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
    public String getReqSysCode () {
        return this.reqSysCode;
    }

    public void setReqSysCode(String reqSysCode) {
        this.reqSysCode = reqSysCode;
    }
    public Long getCreateUserId () {
        return this.createUserId;
    }

    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }
    public String getCreateUserName () {
        return this.createUserName;
    }

    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName;
    }
    public Long getUpdateUserId () {
        return this.updateUserId;
    }

    public void setUpdateUserId(Long updateUserId) {
        this.updateUserId = updateUserId;
    }
    public String getUpdateUserName () {
        return this.updateUserName;
    }

    public void setUpdateUserName(String updateUserName) {
        this.updateUserName = updateUserName;
    }
    public String getTemplateConfig () {
        return this.templateConfig;
    }

    public void setTemplateConfig(String templateConfig) {
        this.templateConfig = templateConfig;
    }
    public String getMsgLink () {
        return this.msgLink;
    }

    public void setMsgLink(String msgLink) {
        this.msgLink = msgLink;
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

    public void copy(MsgTemplate msgTemplate) {
        this.id = msgTemplate.id;
        this.templateType = msgTemplate.templateType;
        this.templateId = msgTemplate.templateId;
        this.templateName = msgTemplate.templateName;
        this.templateVersion = msgTemplate.templateVersion;
        this.msgTitle = msgTemplate.msgTitle;
        this.msgContent = msgTemplate.msgContent;
        this.senderId = msgTemplate.senderId;
        this.senderName = msgTemplate.senderName;
        this.status = msgTemplate.status;
        this.reqSysCode = msgTemplate.reqSysCode;
        this.createUserId = msgTemplate.createUserId;
        this.createUserName = msgTemplate.createUserName;
        this.updateUserId = msgTemplate.updateUserId;
        this.updateUserName = msgTemplate.updateUserName;
        this.templateConfig = msgTemplate.templateConfig;
        this.msgLink = msgTemplate.msgLink;
        this.createTime = msgTemplate.createTime;
        this.updateTime = msgTemplate.updateTime;
    }

}