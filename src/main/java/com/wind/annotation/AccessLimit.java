package com.wind.annotation;

import org.apache.ibatis.annotations.Mapper;

import java.lang.annotation.*;

/**
 * 限制方法访问次数 指定当前数据源连接哪个数据库
 *
 * @author qianchun
 * @date 2019/1/29
 **/
@Target({ ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
@Mapper
public @interface AccessLimit {
    /**
     * 单位秒
     */
    int seconds();

    /**
     * 最大访问次数
     */
    int maxCount();

    /**
     * 是否需要登录
     */
    boolean needLogin() default true;
}
