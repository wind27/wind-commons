package com.wind.model;

import com.wind.common.ErrorCode;

import java.io.Serializable;

/**
 * ResponseData response统一返回实体
 *
 * @author qianchun
 * @date 2019/5/8
 **/
public class ResponseData<T> implements Serializable {
    private ErrorCode errorCode;

    private String desc;

    private T data;

    public ResponseData(ErrorCode errorCode, T data) {
        this.errorCode = errorCode;
        this.data = data;
    }

    public ResponseData(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public ResponseData() {
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
