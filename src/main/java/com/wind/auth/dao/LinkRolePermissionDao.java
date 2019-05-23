package com.wind.auth.dao;

import com.wind.auth.model.LinkRolePermission;
import com.wind.common.Page;
import com.wind.annotation.DAO;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.jdbc.SQL;
import java.util.Map;

/**
 * LinkRolePermissionDao
 * 角色权限关系表
 */
@DAO(catalog = "auth")
public interface LinkRolePermissionDao {

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
    String SELECT_SQL = "SELECT " + COLLOMN + " FROM link_role_permission ";

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
    @Delete("DELETE FROM link_role_permission WHERE id= #{primary}")
    int delete(Long primary);

    /**
    * 根据主键查询
    */
    @Select(SELECT_SQL+ " WHERE id = #{primary} limit 0, 1")
    @Results(id = "linkRolePermissionResult", value={
        @Result(column="id",property="id")
        , @Result(column="role_id",property="roleId")
        , @Result(column="permission_id",property="permissionId")
        , @Result(column="create_time",property="createTime")
        , @Result(column="update_time",property="updateTime")
    })
    LinkRolePermission getByPrimary(Long primary );

    /**
     * 统计
     */
    @Select("SELECT COUNT(1) FROM link_role_permission")
    int count(Map<String, Object> param);

    public class LinkRolePermissionProvider {
        public String insertSelective(LinkRolePermission linkRolePermission) {
            SQL sql = new SQL();
            sql.INSERT_INTO("link_role_permission");

            if (linkRolePermission.getId() != null) {
                sql.VALUES("id", "#{id}");
            }
            if (linkRolePermission.getRoleId() != null) {
                sql.VALUES("role_id", "#{roleId}");
            }
            if (linkRolePermission.getPermissionId() != null) {
                sql.VALUES("permission_id", "#{permissionId}");
            }
            if (linkRolePermission.getCreateTime() != null) {
                sql.VALUES("create_time", "#{createTime}");
            }
            if (linkRolePermission.getUpdateTime() != null) {
                sql.VALUES("update_time", "#{updateTime}");
            }

            return sql.toString();
        }

        public String updateByPrimaryKeySelective(LinkRolePermission linkRolePermission) {
            SQL sql = new SQL();
            sql.UPDATE("link_role_permission");
            if (linkRolePermission.getId() != null) {
                sql.SET("id = #{id}");
            }
            if (linkRolePermission.getRoleId() != null) {
                sql.SET("role_id = #{roleId}");
            }
            if (linkRolePermission.getPermissionId() != null) {
                sql.SET("permission_id = #{permissionId}");
            }
            if (linkRolePermission.getCreateTime() != null) {
                sql.SET("create_time = #{createTime}");
            }
            if (linkRolePermission.getUpdateTime() != null) {
                sql.SET("update_time = #{updateTime}");
            }
            sql.WHERE("id = #{id}");
            return sql.toString();
        }

        public String findPage(Map<String, Object> param) {
            SQL sql = new SQL();
            sql.SELECT(COLLOMN);

            if (param == null || param.size() == 0) {
                sql.FROM(TABLE_NAME);
                return sql.toString();
            }
            StringBuilder condition = new StringBuilder();
            if (condition.length() == 0 && param.get("id") != null) {
                condition.append(" id = #{id} ");
            } else if (condition.length() > 0 && param.get("id") != null) {
                condition.append(" and id = #{id} ");
            }
            if (condition.length() == 0 && param.get("roleId") != null) {
                condition.append(" role_id = #{roleId} ");
            } else if (condition.length() > 0 && param.get("roleId") != null) {
                condition.append(" and role_id = #{roleId} ");
            }
            if (condition.length() == 0 && param.get("permissionId") != null) {
                condition.append(" permission_id = #{permissionId} ");
            } else if (condition.length() > 0 && param.get("permissionId") != null) {
                condition.append(" and permission_id = #{permissionId} ");
            }
            if (condition.length() == 0 && param.get("createTime") != null) {
                condition.append(" create_time = #{createTime} ");
            } else if (condition.length() > 0 && param.get("createTime") != null) {
                condition.append(" and create_time = #{createTime} ");
            }
            if (condition.length() == 0 && param.get("updateTime") != null) {
                condition.append(" update_time = #{updateTime} ");
            } else if (condition.length() > 0 && param.get("updateTime") != null) {
                condition.append(" and update_time = #{updateTime} ");
            }
            sql.FROM(TABLE_NAME);
            if (condition.length() > 0) {
                sql.WHERE(condition.toString());
            }

            String limit = "";
            Page page = null;
            if (param.get("page") != null) {
                page = (Page) param.get("page");
            }
            if (page != null && page.getStart() != null) {
                limit = " limit " + page.getStart() + ", " + page.getLimit();
            }
            return sql.toString() + limit;
        }

        public String count(Map<String, Object> param) {
            SQL sql = new SQL();
            sql.SELECT(COLLOMN);

            if (param == null || param.size() == 0) {
                return sql.toString();
            }

            StringBuilder condition = new StringBuilder();
            if (condition.length() == 0 && param.get("id") != null) {
                condition.append(" id = #{id} ");
            } else if (condition.length() > 0 && param.get("id") != null) {
                condition.append(" and id = #{id} ");
            }
            if (condition.length() == 0 && param.get("roleId") != null) {
                condition.append(" role_id = #{roleId} ");
            } else if (condition.length() > 0 && param.get("roleId") != null) {
                condition.append(" and role_id = #{roleId} ");
            }
            if (condition.length() == 0 && param.get("permissionId") != null) {
                condition.append(" permission_id = #{permissionId} ");
            } else if (condition.length() > 0 && param.get("permissionId") != null) {
                condition.append(" and permission_id = #{permissionId} ");
            }
            if (condition.length() == 0 && param.get("createTime") != null) {
                condition.append(" create_time = #{createTime} ");
            } else if (condition.length() > 0 && param.get("createTime") != null) {
                condition.append(" and create_time = #{createTime} ");
            }
            if (condition.length() == 0 && param.get("updateTime") != null) {
                condition.append(" update_time = #{updateTime} ");
            } else if (condition.length() > 0 && param.get("updateTime") != null) {
                condition.append(" and update_time = #{updateTime} ");
            }
            sql.FROM(TABLE_NAME);
            if (condition.length() > 0) {
                sql.WHERE(condition.toString());
            }
            return sql.toString();
        }
    }
}