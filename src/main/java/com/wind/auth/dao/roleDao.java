package com.wind.auth.dao;

import com.wind.auth.model.Role;
import com.wind.auth.dao.provider.RoleProvider;

import org.apache.ibatis.annotations.*;

/**
 *
 * RoleDao
 * 
 */
@Mapper
interface RoleDao {

    /**
     * 表名
     */
    String TABLE_NAME = "role";

    /**
     * 列名
     */
    String COLLOMN = "id, name, status, create_time, update_time";


    /**
     * 查询语句
     */
    String SELECT_SQL = "SELECT " + COLLOMN + " FROM role";

    /**
     * 新增
     */
    @InsertProvider(type=RoleProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int save(Role role );


    /**
     * 更新
     */
    @UpdateProvider(type=RoleProvider.class, method="updateByPrimaryKeySelective")
    int update(Role role);

    /**
     * 删除
     */
    @Delete("DELETE FROM role WHERE id= :1")
    int delete(Long primary);

    /**
    * 根据主键查询
    */
    @Select(SELECT_SQL+ " WHERE id = :1")
    Role getByPrimary(Long primary );

    /**
     * 统计
     */
    @Select("SELECT COUNT(1) FROM role")
    long count();
}