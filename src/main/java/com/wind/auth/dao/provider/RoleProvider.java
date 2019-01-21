package com.wind.auth.dao.provider;

import com.wind.auth.model.Role;
import org.apache.ibatis.jdbc.SQL;

/**
 *
 * RoleProvider
 * 
 */
public class RoleProvider {

    public String insertSelective(Role role) {
        SQL sql = new SQL();
        sql.INSERT_INTO("role");

            if (role.getId() != null) {
                sql.VALUES("id", "#{id");
            }
            if (role.getName() != null) {
                sql.VALUES("name", "#{name");
            }
            if (role.getStatus() != null) {
                sql.VALUES("status", "#{status");
            }
            if (role.getCreateTime() != null) {
                sql.VALUES("create_time", "#{createTime");
            }
            if (role.getUpdateTime() != null) {
                sql.VALUES("update_time", "#{updateTime");
            }

        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Role role) {
        SQL sql = new SQL();
        sql.UPDATE("role");

        if (role.getId() != null) {
            sql.SET("id = #{Id");
        }
        if (role.getName() != null) {
            sql.SET("name = #{Name");
        }
        if (role.getStatus() != null) {
            sql.SET("status = #{Status");
        }
        if (role.getCreateTime() != null) {
            sql.SET("create_time = #{CreateTime");
        }
        if (role.getUpdateTime() != null) {
            sql.SET("update_time = #{UpdateTime");
        }

        sql.WHERE("id = #{id");

        return sql.toString();
    }


}