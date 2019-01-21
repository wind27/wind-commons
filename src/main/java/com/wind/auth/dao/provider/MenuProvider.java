package com.wind.auth.dao.provider;

import com.wind.auth.model.Menu;
import org.apache.ibatis.jdbc.SQL;

/**
 *
 * MenuProvider
 * 
 */
public class MenuProvider {

    public String insertSelective(Menu menu) {
        SQL sql = new SQL();
        sql.INSERT_INTO("menu");

            if (menu.getId() != null) {
                sql.VALUES("id", "#{id");
            }
            if (menu.getName() != null) {
                sql.VALUES("name", "#{name");
            }
            if (menu.getStatus() != null) {
                sql.VALUES("status", "#{status");
            }
            if (menu.getAppId() != null) {
                sql.VALUES("app_id", "#{appId");
            }
            if (menu.getUrl() != null) {
                sql.VALUES("url", "#{url");
            }
            if (menu.getCreateTime() != null) {
                sql.VALUES("create_time", "#{createTime");
            }
            if (menu.getUpdateTime() != null) {
                sql.VALUES("update_time", "#{updateTime");
            }
            if (menu.getParentId() != null) {
                sql.VALUES("parent_id", "#{parentId");
            }

        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Menu menu) {
        SQL sql = new SQL();
        sql.UPDATE("menu");

        if (menu.getId() != null) {
            sql.SET("id = #{Id");
        }
        if (menu.getName() != null) {
            sql.SET("name = #{Name");
        }
        if (menu.getStatus() != null) {
            sql.SET("status = #{Status");
        }
        if (menu.getAppId() != null) {
            sql.SET("app_id = #{AppId");
        }
        if (menu.getUrl() != null) {
            sql.SET("url = #{Url");
        }
        if (menu.getCreateTime() != null) {
            sql.SET("create_time = #{CreateTime");
        }
        if (menu.getUpdateTime() != null) {
            sql.SET("update_time = #{UpdateTime");
        }
        if (menu.getParentId() != null) {
            sql.SET("parent_id = #{ParentId");
        }

        sql.WHERE("id = #{id");

        return sql.toString();
    }


}