package com.wind.auth.dao.provider;

import com.wind.auth.model.LinkUserRole;
import org.apache.ibatis.jdbc.SQL;

/**
 *
 * LinkUserRoleProvider
 * 用户角色关系表
 */
public class LinkUserRoleProvider {

    public String insertSelective(LinkUserRole linkUserRole) {
        SQL sql = new SQL();
        sql.INSERT_INTO("link_user_role");

            if (linkUserRole.getId() != null) {
                sql.VALUES("id", "#{id");
            }
            if (linkUserRole.getUserId() != null) {
                sql.VALUES("user_id", "#{userId");
            }
            if (linkUserRole.getRoleId() != null) {
                sql.VALUES("role_id", "#{roleId");
            }
            if (linkUserRole.getCreateTime() != null) {
                sql.VALUES("create_time", "#{createTime");
            }
            if (linkUserRole.getUpdateTime() != null) {
                sql.VALUES("update_time", "#{updateTime");
            }

        return sql.toString();
    }

    public String updateByPrimaryKeySelective(LinkUserRole linkUserRole) {
        SQL sql = new SQL();
        sql.UPDATE("link_user_role");

        if (linkUserRole.getId() != null) {
            sql.SET("id = #{Id");
        }
        if (linkUserRole.getUserId() != null) {
            sql.SET("user_id = #{UserId");
        }
        if (linkUserRole.getRoleId() != null) {
            sql.SET("role_id = #{RoleId");
        }
        if (linkUserRole.getCreateTime() != null) {
            sql.SET("create_time = #{CreateTime");
        }
        if (linkUserRole.getUpdateTime() != null) {
            sql.SET("update_time = #{UpdateTime");
        }

        sql.WHERE("id = #{id");

        return sql.toString();
    }


}