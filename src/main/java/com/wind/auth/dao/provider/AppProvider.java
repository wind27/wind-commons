package com.wind.auth.dao.provider;

import com.wind.auth.model.App;
import org.apache.ibatis.jdbc.SQL;

/**
 *
 * AppProvider
 * 应用APP
 */
public class AppProvider {

    public String insertSelective(App app) {
        SQL sql = new SQL();
        sql.INSERT_INTO("app");

            if (app.getId() != null) {
                sql.VALUES("id", "#{id");
            }
            if (app.getName() != null) {
                sql.VALUES("name", "#{name");
            }
            if (app.getHomePageUrl() != null) {
                sql.VALUES("home_page_url", "#{homePageUrl");
            }
            if (app.getStatus() != null) {
                sql.VALUES("status", "#{status");
            }
            if (app.getCreateTime() != null) {
                sql.VALUES("create_time", "#{createTime");
            }
            if (app.getUpdateTime() != null) {
                sql.VALUES("update_time", "#{updateTime");
            }

        return sql.toString();
    }

    public String updateByPrimaryKeySelective(App app) {
        SQL sql = new SQL();
        sql.UPDATE("app");

        if (app.getId() != null) {
            sql.SET("id = #{Id");
        }
        if (app.getName() != null) {
            sql.SET("name = #{Name");
        }
        if (app.getHomePageUrl() != null) {
            sql.SET("home_page_url = #{HomePageUrl");
        }
        if (app.getStatus() != null) {
            sql.SET("status = #{Status");
        }
        if (app.getCreateTime() != null) {
            sql.SET("create_time = #{CreateTime");
        }
        if (app.getUpdateTime() != null) {
            sql.SET("update_time = #{UpdateTime");
        }

        sql.WHERE("id = #{id");

        return sql.toString();
    }


}