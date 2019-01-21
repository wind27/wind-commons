package com.wind.auth.dao;

import com.wind.auth.model.LinkRolePermission;
import com.wind.auth.dao.provider.LinkRolePermissionProvider;

import org.apache.ibatis.annotations.*;

/**
 *
 * LinkRolePermissionDao
 * 角色权限关系表
 */
@Mapper
interface LinkRolePermissionDao {

    /**
     * 表名
     */
    String TABLE_NAME = "link_role_permission";

    /**
     * 列名
     */
    String COLLOMN = "id, role_id, permission_id, create_time, update_time";


    /**
     * 查询语句
     */
    String SELECT_SQL = "SELECT " + COLLOMN + " FROM link_role_permission";

    /**
     * 新增
     */
    @InsertProvider(type=LinkRolePermissionProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int save(LinkRolePermission linkRolePermission );


    /**
     * 更新
     */
    @UpdateProvider(type=LinkRolePermissionProvider.class, method="updateByPrimaryKeySelective")
    int update(LinkRolePermission linkRolePermission);

    /**
     * 删除
     */
    @Delete("DELETE FROM link_role_permission WHERE id= :1")
    int delete(Long primary);

    /**
    * 根据主键查询
    */
    @Select(SELECT_SQL+ " WHERE id = :1")
    LinkRolePermission getByPrimary(Long primary );

    /**
     * 统计
     */
    @Select("SELECT COUNT(1) FROM link_role_permission")
    long count();
}