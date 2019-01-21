package com.wind.auth.dao.provider;

import com.wind.auth.model.User;
import org.apache.ibatis.jdbc.SQL;

/**
 *
 * UserProvider
 * 用户表
 */
public class UserProvider {

    public String insertSelective(User user) {
        SQL sql = new SQL();
        sql.INSERT_INTO("user");

            if (user.getId() != null) {
                sql.VALUES("id", "#{id");
            }
            if (user.getUsername() != null) {
                sql.VALUES("username", "#{username");
            }
            if (user.getRealname() != null) {
                sql.VALUES("realname", "#{realname");
            }
            if (user.getSalt() != null) {
                sql.VALUES("salt", "#{salt");
            }
            if (user.getPassword() != null) {
                sql.VALUES("password", "#{password");
            }
            if (user.getStatus() != null) {
                sql.VALUES("status", "#{status");
            }
            if (user.getCreateTime() != null) {
                sql.VALUES("create_time", "#{createTime");
            }
            if (user.getUpdateTime() != null) {
                sql.VALUES("update_time", "#{updateTime");
            }
            if (user.getMobile() != null) {
                sql.VALUES("mobile", "#{mobile");
            }
            if (user.getIdcard() != null) {
                sql.VALUES("idcard", "#{idcard");
            }
            if (user.getEmail() != null) {
                sql.VALUES("email", "#{email");
            }

        return sql.toString();
    }

    public String updateByPrimaryKeySelective(User user) {
        SQL sql = new SQL();
        sql.UPDATE("user");

        if (user.getId() != null) {
            sql.SET("id = #{Id");
        }
        if (user.getUsername() != null) {
            sql.SET("username = #{Username");
        }
        if (user.getRealname() != null) {
            sql.SET("realname = #{Realname");
        }
        if (user.getSalt() != null) {
            sql.SET("salt = #{Salt");
        }
        if (user.getPassword() != null) {
            sql.SET("password = #{Password");
        }
        if (user.getStatus() != null) {
            sql.SET("status = #{Status");
        }
        if (user.getCreateTime() != null) {
            sql.SET("create_time = #{CreateTime");
        }
        if (user.getUpdateTime() != null) {
            sql.SET("update_time = #{UpdateTime");
        }
        if (user.getMobile() != null) {
            sql.SET("mobile = #{Mobile");
        }
        if (user.getIdcard() != null) {
            sql.SET("idcard = #{Idcard");
        }
        if (user.getEmail() != null) {
            sql.SET("email = #{Email");
        }

        sql.WHERE("id = #{id");

        return sql.toString();
    }


}