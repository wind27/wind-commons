package com.wind.auth.dao;

import com.wind.auth.model.User;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Mapper;

/**
 *
 * ${table.daoName2}
 * 用户表
 */
@Mapper
interface UserDao {

    /**
     * 表名
     */
    String TABLE_NAME = "user";
    String SELECT_SQL = "SELECT id, username, realname, salt, password, status, create_time, update_time, mobile, idcard, email FROM user";
        
    /**
     * 新增 sql
     */
    String INSERT_SQL = "INSERT INTO user ("+
"id"+"#if(:1.username!=null){,username}"+"#if(:1.realname!=null){,realname}"+"#if(:1.salt!=null){,salt}"+"#if(:1.password!=null){,password}"+"#if(:1.status!=null){,status}"+"#if(:1.createTime!=null){,create_time}"+"#if(:1.updateTime!=null){,update_time}"+"#if(:1.mobile!=null){,mobile}"+"#if(:1.idcard!=null){,idcard}"+"#if(:1.email!=null){,email}"+        ") VALUES("+
":1.id"+"#if(:1.username!=null){,:1.username}"+"#if(:1.realname!=null){,:1.realname}"+"#if(:1.salt!=null){,:1.salt}"+"#if(:1.password!=null){,:1.password}"+"#if(:1.status!=null){,:1.status}"+"#if(:1.createTime!=null){,:1.create_time}"+"#if(:1.updateTime!=null){,:1.update_time}"+"#if(:1.mobile!=null){,:1.mobile}"+"#if(:1.idcard!=null){,:1.idcard}"+"#if(:1.email!=null){,:1.email}"+        ")";

    /**
     * 批量新增 sql
     */
    String INSERT_SQL_BAT = "INSERT INTO user ("+
"id"+"#if(:1[0].username!=null){,username}"+"#if(:1[0].realname!=null){,realname}"+"#if(:1[0].salt!=null){,salt}"+"#if(:1[0].password!=null){,password}"+"#if(:1[0].status!=null){,status}"+"#if(:1[0].createTime!=null){,create_time}"+"#if(:1[0].updateTime!=null){,update_time}"+"#if(:1[0].mobile!=null){,mobile}"+"#if(:1[0].idcard!=null){,idcard}"+"#if(:1[0].email!=null){,email}"+    ") VALUES ${jing}for(item in :1){ #if(:loopIndex>0){,} ("+
":item.id"+"#if(:item.username!=null){,:item.username}"+"#if(:item.realname!=null){,:item.realname}"+"#if(:item.salt!=null){,:item.salt}"+"#if(:item.password!=null){,:item.password}"+"#if(:item.status!=null){,:item.status}"+"#if(:item.createTime!=null){,:item.create_time}"+"#if(:item.updateTime!=null){,:item.update_time}"+"#if(:item.mobile!=null){,:item.mobile}"+"#if(:item.idcard!=null){,:item.idcard}"+"#if(:item.email!=null){,:item.email}"+    ") }";

    /**
     * 更新 sql
     */
    String UPDATE_COLS =
"#if(:1.username!=null){,username=:1.username}"+"#if(:1.realname!=null){,realname=:1.realname}"+"#if(:1.salt!=null){,salt=:1.salt}"+"#if(:1.password!=null){,password=:1.password}"+"#if(:1.status!=null){,status=:1.status}"+"#if(:1.createTime!=null){,create_time=:1.createTime}"+"#if(:1.updateTime!=null){,update_time=:1.updateTime}"+"#if(:1.mobile!=null){,mobile=:1.mobile}"+"#if(:1.idcard!=null){,idcard=:1.idcard}"+"#if(:1.email!=null){,email=:1.email}"+    "";

    /**
     * 新增
     */
    @Options(useGeneratedKeys = true, keyProperty = "email")
    @Insert(INSERT_SQL)
    int save(User user );

    /**
     * 批量新增
     */
    @Insert(INSERT_SQL_BAT)
    int saveBatch(List<User> userList);

    /**
     * 更新
     */
    @Update("UPDATE user SET email=:1.email " +UPDATE_COLS+" WHERE email=:1.email ")
    int update(User user);

    /**
     * 删除
     */
    @Delete("DELETE FROM user WHERE email= :1")
    int delete(String primary);

    /**
     * 批量删除
     */
    @Delete("DELETE FROM user WHERE email in (:1)")
    int deleteByPrimaryList(List<String> primaryList);

    /**
    * 根据主键查询
    */
    @Select(SELECT_SQL+ " WHERE email = :1")
    User getByPrimary(String primary );

    /**
    * 根据主键ids查询 list
    */
    @Select(SELECT_SQL+ " WHERE email IN (:1)")
    List<User> getListByPrimaryList(List<String> primaryList );

    /**
    * 根据主键ids查询 map
    */
    @Select(SELECT_SQL+ " WHERE email IN (:1)")
    @MapKey("email")
    Map<String,User> getMapByPrimaryList(List<String> primaryList);

    /**
     * 统计
     */
    @Select("SELECT COUNT(1) FROM user")
    long count();



}