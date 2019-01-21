package com.wind.auth.dao.provider;

import com.wind.auth.model.Permission;
import org.apache.ibatis.jdbc.SQL;

/**
 *
 * PermissionProvider
 * 权限表
 */
public class PermissionProvider {

    public String insertSelective(Permission permission) {
        SQL sql = new SQL();
        sql.INSERT_INTO("permission");

            if (permission.getId() != null) {
                sql.VALUES("id", "#{id");
            }
            if (permission.getName() != null) {
                sql.VALUES("name", "#{name");
            }
            if (permission.getValue() != null) {
                sql.VALUES("value", "#{value");
            }
            if (permission.getStatus() != null) {
                sql.VALUES("status", "#{status");
            }
            if (permission.getCreateTime() != null) {
                sql.VALUES("create_time", "#{createTime");
            }
            if (permission.getUpdateTime() != null) {
                sql.VALUES("update_time", "#{updateTime");
            }

        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Permission permission) {
        SQL sql = new SQL();
        sql.UPDATE("permission");

        if (permission.getId() != null) {
            sql.SET("id = #{Id");
        }
        if (permission.getName() != null) {
            sql.SET("name = #{Name");
        }
        if (permission.getValue() != null) {
            sql.SET("value = #{Value");
        }
        if (permission.getStatus() != null) {
            sql.SET("status = #{Status");
        }
        if (permission.getCreateTime() != null) {
            sql.SET("create_time = #{CreateTime");
        }
        if (permission.getUpdateTime() != null) {
            sql.SET("update_time = #{UpdateTime");
        }

        sql.WHERE("id = #{id");

        return sql.toString();
    }


}