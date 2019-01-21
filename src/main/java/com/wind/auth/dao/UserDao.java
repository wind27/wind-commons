package com.wind.auth.dao;

import com.wind.auth.model.User;
import com.wind.auth.dao.provider.UserProvider;

import org.apache.ibatis.annotations.*;

/**
 *
 * UserDao
 * 用户表
 */
@Mapper
interface UserDao {

    /**
     * 表名
     */
    String TABLE_NAME = "user";

    /**
     * 列名
     */
    String COLLOMN = "id, username, realname, salt, password, status, create_time, update_time, mobile, idcard, email";


    /**
     * 查询语句
     */
    String SELECT_SQL = "SELECT " + COLLOMN + " FROM user";

    /**
     * 新增
     */
    @InsertProvider(type=UserProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int save(User user );


    /**
     * 更新
     */
    @UpdateProvider(type=UserProvider.class, method="updateByPrimaryKeySelective")
    int update(User user);

    /**
     * 删除
     */
    @Delete("DELETE FROM user WHERE id= :1")
    int delete(Long primary);

    /**
    * 根据主键查询
    */
    @Select(SELECT_SQL+ " WHERE id = :1")
    User getByPrimary(Long primary );

    /**
     * 统计
     */
    @Select("SELECT COUNT(1) FROM user")
    long count();
}