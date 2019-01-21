package com.wind.auth.dao;

import com.wind.auth.model.LinkUserRole;
import com.wind.auth.dao.provider.LinkUserRoleProvider;

import org.apache.ibatis.annotations.*;

/**
 *
 * LinkUserRoleDao
 * 用户角色关系表
 */
@Mapper
interface LinkUserRoleDao {

    /**
     * 表名
     */
    String TABLE_NAME = "link_user_role";

    /**
     * 列名
     */
    String COLLOMN = "id, user_id, role_id, create_time, update_time";


    /**
     * 查询语句
     */
    String SELECT_SQL = "SELECT " + COLLOMN + " FROM link_user_role";

    /**
     * 新增
     */
    @InsertProvider(type=LinkUserRoleProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int save(LinkUserRole linkUserRole );


    /**
     * 更新
     */
    @UpdateProvider(type=LinkUserRoleProvider.class, method="updateByPrimaryKeySelective")
    int update(LinkUserRole linkUserRole);

    /**
     * 删除
     */
    @Delete("DELETE FROM link_user_role WHERE id= :1")
    int delete(Long primary);

    /**
    * 根据主键查询
    */
    @Select(SELECT_SQL+ " WHERE id = :1")
    LinkUserRole getByPrimary(Long primary );

    /**
     * 统计
     */
    @Select("SELECT COUNT(1) FROM link_user_role")
    long count();
}