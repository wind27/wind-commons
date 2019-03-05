package com.wind.annotation;

import org.apache.ibatis.annotations.Mapper;

import java.lang.annotation.*;

/**
 * DAO mybatis类注解
 * 指定当前数据源连接哪个数据库
 *
 * @author qianchun
 * @date 2019/1/29
 **/
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
@Mapper
public @interface DAO {
    String catalog() default "";
}
