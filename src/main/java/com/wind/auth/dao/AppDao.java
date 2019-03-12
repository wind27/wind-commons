package com.wind.auth.dao;

import com.wind.auth.model.App;
import com.wind.common.Page;
import com.wind.annotation.DAO;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.jdbc.SQL;
import java.util.Map;

/**
 * AppDao
 * 应用APP
 */
@DAO(catalog = "auth")
public interface AppDao {

    /**
     * 表名
     */
    String TABLE_NAME = "app";

    /**
     * 列名
     */
    String COLLOMN = "id, name, home_page_url, status, create_time, update_time";


    /**
     * 查询语句
     */
    String SELECT_SQL = "SELECT " + COLLOMN + " FROM app";

    /**
     * 新增
     */
    @InsertProvider(type=AppProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int save(App app );


    /**
     * 更新
     */
    @UpdateProvider(type=AppProvider.class, method="updateByPrimaryKeySelective")
    int update(App app);

    /**
     * 删除
     */
    @Delete("DELETE FROM app WHERE id= #{primary}")
    int delete(Long primary);

    /**
    * 根据主键查询
    */
    @Select(SELECT_SQL+ " WHERE id = #{primary} limit 0, 1")
    App getByPrimary(Long primary );

    /**
     * 统计
     */
    @Select("SELECT COUNT(1) FROM app")
    int count(Map<String, Object> param);

    public class AppProvider {
        public String insertSelective(App app) {
            SQL sql = new SQL();
            sql.INSERT_INTO("app");

            if (app.getId() != null) {
                sql.VALUES("id", "#{id}");
            }
            if (app.getName() != null) {
                sql.VALUES("name", "#{name}");
            }
            if (app.getHomePageUrl() != null) {
                sql.VALUES("home_page_url", "#{homePageUrl}");
            }
            if (app.getStatus() != null) {
                sql.VALUES("status", "#{status}");
            }
            if (app.getCreateTime() != null) {
                sql.VALUES("create_time", "#{createTime}");
            }
            if (app.getUpdateTime() != null) {
                sql.VALUES("update_time", "#{updateTime}");
            }

            return sql.toString();
        }

        public String updateByPrimaryKeySelective(App app) {
            SQL sql = new SQL();
            sql.UPDATE("app");
            if (app.getId() != null) {
                sql.SET("id = #{id}");
            }
            if (app.getName() != null) {
                sql.SET("name = #{name}");
            }
            if (app.getHomePageUrl() != null) {
                sql.SET("home_page_url = #{homePageUrl}");
            }
            if (app.getStatus() != null) {
                sql.SET("status = #{status}");
            }
            if (app.getCreateTime() != null) {
                sql.SET("create_time = #{createTime}");
            }
            if (app.getUpdateTime() != null) {
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
            if (condition.length() == 0 && param.get("name") != null) {
                condition.append(" name = #{name} ");
            } else if (condition.length() > 0 && param.get("name") != null) {
                condition.append(" and name = #{name} ");
            }
            if (condition.length() == 0 && param.get("homePageUrl") != null) {
                condition.append(" home_page_url = #{homePageUrl} ");
            } else if (condition.length() > 0 && param.get("homePageUrl") != null) {
                condition.append(" and home_page_url = #{homePageUrl} ");
            }
            if (condition.length() == 0 && param.get("status") != null) {
                condition.append(" status = #{status} ");
            } else if (condition.length() > 0 && param.get("status") != null) {
                condition.append(" and status = #{status} ");
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
            if (condition.length() == 0 && param.get("name") != null) {
                condition.append(" name = #{name} ");
            } else if (condition.length() > 0 && param.get("name") != null) {
                condition.append(" and name = #{name} ");
            }
            if (condition.length() == 0 && param.get("homePageUrl") != null) {
                condition.append(" home_page_url = #{homePageUrl} ");
            } else if (condition.length() > 0 && param.get("homePageUrl") != null) {
                condition.append(" and home_page_url = #{homePageUrl} ");
            }
            if (condition.length() == 0 && param.get("status") != null) {
                condition.append(" status = #{status} ");
            } else if (condition.length() > 0 && param.get("status") != null) {
                condition.append(" and status = #{status} ");
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