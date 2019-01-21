package com.wind.auth.dao.provider;

import com.wind.auth.model.LinkRolePermission;
import org.apache.ibatis.jdbc.SQL;

/**
 *
 * LinkRolePermissionProvider
 * 角色权限关系表
 */
public class LinkRolePermissionProvider {

    public String insertSelective(LinkRolePermission linkRolePermission) {
        SQL sql = new SQL();
        sql.INSERT_INTO("link_role_permission");

            if (linkRolePermission.getId() != null) {
                sql.VALUES("id", "#{id");
            }
            if (linkRolePermission.getRoleId() != null) {
                sql.VALUES("role_id", "#{roleId");
            }
            if (linkRolePermission.getPermissionId() != null) {
                sql.VALUES("permission_id", "#{permissionId");
            }
            if (linkRolePermission.getCreateTime() != null) {
                sql.VALUES("create_time", "#{createTime");
            }
            if (linkRolePermission.getUpdateTime() != null) {
                sql.VALUES("update_time", "#{updateTime");
            }

        return sql.toString();
    }

    public String updateByPrimaryKeySelective(LinkRolePermission linkRolePermission) {
        SQL sql = new SQL();
        sql.UPDATE("link_role_permission");

        if (linkRolePermission.getId() != null) {
            sql.SET("id = #{Id");
        }
        if (linkRolePermission.getRoleId() != null) {
            sql.SET("role_id = #{RoleId");
        }
        if (linkRolePermission.getPermissionId() != null) {
            sql.SET("permission_id = #{PermissionId");
        }
        if (linkRolePermission.getCreateTime() != null) {
            sql.SET("create_time = #{CreateTime");
        }
        if (linkRolePermission.getUpdateTime() != null) {
            sql.SET("update_time = #{UpdateTime");
        }

        sql.WHERE("id = #{id");

        return sql.toString();
    }


}