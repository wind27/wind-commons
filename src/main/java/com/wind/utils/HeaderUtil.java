package com.wind.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

/**
 * IP 工具类
 */
public class HeaderUtil {
    private final static Logger logger = LoggerFactory.getLogger(HeaderUtil.class);

    /**
     * 判断是否为ajax请求.
     *
     * 1> requestedWith 为 null，则为同步请求.
     * 2> requestedWith 为 XMLHttpRequest 则为 Ajax 请求。
     * 
     * @param request request
     * @return 返回结果
     */
    public static String getRequestType(HttpServletRequest request) {
        return request.getHeader("X-Requested-With");
    }
}