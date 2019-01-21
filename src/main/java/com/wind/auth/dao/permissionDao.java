package com.wind.auth.dao;

import com.wind.auth.model.Permission;
import com.wind.auth.dao.provider.PermissionProvider;

import org.apache.ibatis.annotations.*;

/**
 *
 * PermissionDao
 * 权限表
 */
@Mapper
interface PermissionDao {

    /**
     * 表名
     */
    String TABLE_NAME = "permission";

    /**
     * 列名
     */
    String COLLOMN = "id, name, value, status, create_time, update_time";


    /**
     * 查询语句
     */
    String SELECT_SQL = "SELECT " + COLLOMN + " FROM permission";

    /**
     * 新增
     */
    @InsertProvider(type=PermissionProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int save(Permission permission );


    /**
     * 更新
     */
    @UpdateProvider(type=PermissionProvider.class, method="updateByPrimaryKeySelective")
    int update(Permission permission);

    /**
     * 删除
     */
    @Delete("DELETE FROM permission WHERE id= :1")
    int delete(Long primary);

    /**
    * 根据主键查询
    */
    @Select(SELECT_SQL+ " WHERE id = :1")
    Permission getByPrimary(Long primary );

    /**
     * 统计
     */
    @Select("SELECT COUNT(1) FROM permission")
    long count();
}