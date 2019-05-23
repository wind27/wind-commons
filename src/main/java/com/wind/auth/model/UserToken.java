package com.wind.auth.model;

import java.io.Serializable;
import java.util.Date;

/**
 * ç”¨æˆ·ç™»å½•token
 */
public class UserToken implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
    * ä¸»é”®id
    */
    private Long id;
    /**
    * ç”¨æˆ·id
    */
    private Long userId;
    /**
    * token
    */
    private String token;
    /**
    * å®¢æˆ·ç«¯IP
    */
    private String clientIp;
    /**
    * åˆ›å»ºæ—¶é—´
    */
    private Date createTime;
    /**
    * ç”¨æˆ·å
    */
    private String username;


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
    public String getToken () {
        return this.token;
    }

    public void setToken(String token) {
        this.token = token;
    }
    public String getClientIp () {
        return this.clientIp;
    }

    public void setClientIp(String clientIp) {
        this.clientIp = clientIp;
    }
    public Date getCreateTime () {
        return this.createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    public String getUsername () {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void copy(UserToken userToken) {
        this.id = userToken.id;
        this.userId = userToken.userId;
        this.token = userToken.token;
        this.clientIp = userToken.clientIp;
        this.createTime = userToken.createTime;
        this.username = userToken.username;
    }

}