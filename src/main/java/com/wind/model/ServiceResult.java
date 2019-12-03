package com.wind.model;

import com.wind.common.ErrorCode;

import java.util.List;

/**
 * ServiceResult
 *
 * @author qianchun
 * @date 2019/11/30
 **/
public class ServiceResult<T> extends BaseObject {

    private ErrorCode errorCode = ErrorCode.SUCCESS;

    private List<T> list;

    private T t;

    private Object date;

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public Object getDate() {
        return date;
    }

    public void setDate(Object date) {
        this.date = date;
    }
}
