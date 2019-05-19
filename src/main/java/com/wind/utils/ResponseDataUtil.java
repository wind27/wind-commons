package com.wind.utils;

import com.alibaba.fastjson.JSONObject;
import com.wind.common.ErrorCode;

import java.util.HashMap;
import java.util.Map;

/**
 * JsonResponseUtil
 *
 * @author qianchun 17/7/13
 **/
//ResponseDataUtil
public class ResponseDataUtil {

    public static Map<String, Object> okTest() {
        Map<String, Object> result = new HashMap<>();
        result.put("code", ErrorCode.SUCCESS.getValue());
        result.put("msg", ErrorCode.SUCCESS.getName());
        return result;
    }

    // public static Map<String, Object> ok() {
    // Map<String, Object> result = new HashMap<>();
    // result.put("code", ErrorCode.SUCCESS.getValue());
    // result.put("msg", ErrorCode.SUCCESS.getName());
    // return result;
    // }
    //
    // public static Map<String, Object> ok(Object obj) {
    // Map<String, Object> result = new HashMap<>();
    // result.put("code", ErrorCode.SUCCESS.getValue());
    // result.put("msg", ErrorCode.SUCCESS.getName());
    // result.put("data", obj);
    // return result;
    // }
    //
    // public static Map<String, Object> fail() {
    // Map<String, Object> result = new HashMap<>();
    // result.put("code", ErrorCode.FAIL.getValue());
    // result.put("msg", ErrorCode.FAIL.getName());
    // return result;
    // }
    //
    // public static Map<String, Object> fail(ErrorCode errorCode) {
    // Map<String, Object> result = new HashMap<>();
    // result.put("code", errorCode.getValue());
    // result.put("msg", errorCode.getName());
    // return result;
    // }
    //
    // public static Map<String, Object> fail(int code, String msg) {
    // Map<String, Object> result = new HashMap<>();
    // result.put("code", code);
    // result.put("msg", msg);
    // return result;
    // }

    public static String ok() {
        JSONObject result = new JSONObject();
        result.put("code", ErrorCode.SUCCESS.getValue());
        result.put("msg", ErrorCode.SUCCESS.getName());
        return result.toString();
    }

    public static String ok(Object obj) {
        JSONObject result = new JSONObject();
        result.put("code", ErrorCode.SUCCESS.getValue());
        result.put("msg", ErrorCode.SUCCESS.getName());
        result.put("data", obj);
        return result.toString();
    }

    public static String fail() {
        JSONObject result = new JSONObject();
        result.put("code", ErrorCode.FAIL.getValue());
        result.put("msg", ErrorCode.FAIL.getName());
        return result.toString();
    }

    public static String fail(ErrorCode errorCode) {
        JSONObject result = new JSONObject();
        result.put("code", errorCode.getValue());
        result.put("msg", errorCode.getName());
        return result.toString();
    }

    public static String fail(int code, String msg) {
        JSONObject result = new JSONObject();
        result.put("code", code);
        result.put("msg", msg);
        return result.toString();
    }
}
