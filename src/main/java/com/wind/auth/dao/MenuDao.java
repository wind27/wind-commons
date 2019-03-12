package com.wind.auth.dao;

import com.wind.auth.model.Menu;
import com.wind.common.Page;
import com.wind.annotation.DAO;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.jdbc.SQL;
import java.util.Map;

/**
 * MenuDao
 * 
 */
@DAO(catalog = "auth")
public interface MenuDao {

    /**
     * 表名
     */
    String TABLE_NAME = "menu";

    /**
     * 列名
     */
    String COLLOMN = "id, name, status, app_id, url, create_time, update_time, parent_id";


    /**
     * 查询语句
     */
    String SELECT_SQL = "SELECT " + COLLOMN + " FROM menu";

    /**
     * 新增
     */
    @InsertProvider(type=MenuProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int save(Menu menu );


    /**
     * 更新
     */
    @UpdateProvider(type=MenuProvider.class, method="updateByPrimaryKeySelective")
    int update(Menu menu);

    /**
     * 删除
     */
    @Delete("DELETE FROM menu WHERE id= #{primary}")
    int delete(Long primary);

    /**
    * 根据主键查询
    */
    @Select(SELECT_SQL+ " WHERE id = #{primary} limit 0, 1")
    Menu getByPrimary(Long primary );

    /**
     * 统计
     */
    @Select("SELECT COUNT(1) FROM menu")
    int count(Map<String, Object> param);

    public class MenuProvider {
        public String insertSelective(Menu menu) {
            SQL sql = new SQL();
            sql.INSERT_INTO("menu");

            if (menu.getId() != null) {
                sql.VALUES("id", "#{id}");
            }
            if (menu.getName() != null) {
                sql.VALUES("name", "#{name}");
            }
            if (menu.getStatus() != null) {
                sql.VALUES("status", "#{status}");
            }
            if (menu.getAppId() != null) {
                sql.VALUES("app_id", "#{appId}");
            }
            if (menu.getUrl() != null) {
                sql.VALUES("url", "#{url}");
            }
            if (menu.getCreateTime() != null) {
                sql.VALUES("create_time", "#{createTime}");
            }
            if (menu.getUpdateTime() != null) {
                sql.VALUES("update_time", "#{updateTime}");
            }
            if (menu.getParentId() != null) {
                sql.VALUES("parent_id", "#{parentId}");
            }

            return sql.toString();
        }

        public String updateByPrimaryKeySelective(Menu menu) {
            SQL sql = new SQL();
            sql.UPDATE("menu");
            if (menu.getId() != null) {
                sql.SET("id = #{id}");
            }
            if (menu.getName() != null) {
                sql.SET("name = #{name}");
            }
            if (menu.getStatus() != null) {
                sql.SET("status = #{status}");
            }
            if (menu.getAppId() != null) {
                sql.SET("app_id = #{appId}");
            }
            if (menu.getUrl() != null) {
                sql.SET("url = #{url}");
            }
            if (menu.getCreateTime() != null) {
                sql.SET("create_time = #{createTime}");
            }
            if (menu.getUpdateTime() != null) {
                sql.SET("update_time = #{updateTime}");
            }
            if (menu.getParentId() != null) {
                sql.SET("parent_id = #{parentId}");
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
            if (condition.length() == 0 && param.get("status") != null) {
                condition.append(" status = #{status} ");
            } else if (condition.length() > 0 && param.get("status") != null) {
                condition.append(" and status = #{status} ");
            }
            if (condition.length() == 0 && param.get("appId") != null) {
                condition.append(" app_id = #{appId} ");
            } else if (condition.length() > 0 && param.get("appId") != null) {
                condition.append(" and app_id = #{appId} ");
            }
            if (condition.length() == 0 && param.get("url") != null) {
                condition.append(" url = #{url} ");
            } else if (condition.length() > 0 && param.get("url") != null) {
                condition.append(" and url = #{url} ");
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
            if (condition.length() == 0 && param.get("parentId") != null) {
                condition.append(" parent_id = #{parentId} ");
            } else if (condition.length() > 0 && param.get("parentId") != null) {
                condition.append(" and parent_id = #{parentId} ");
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
            if (condition.length() == 0 && param.get("status") != null) {
                condition.append(" status = #{status} ");
            } else if (condition.length() > 0 && param.get("status") != null) {
                condition.append(" and status = #{status} ");
            }
            if (condition.length() == 0 && param.get("appId") != null) {
                condition.append(" app_id = #{appId} ");
            } else if (condition.length() > 0 && param.get("appId") != null) {
                condition.append(" and app_id = #{appId} ");
            }
            if (condition.length() == 0 && param.get("url") != null) {
                condition.append(" url = #{url} ");
            } else if (condition.length() > 0 && param.get("url") != null) {
                condition.append(" and url = #{url} ");
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
            if (condition.length() == 0 && param.get("parentId") != null) {
                condition.append(" parent_id = #{parentId} ");
            } else if (condition.length() > 0 && param.get("parentId") != null) {
                condition.append(" and parent_id = #{parentId} ");
            }
            sql.FROM(TABLE_NAME);
            if (condition.length() > 0) {
                sql.WHERE(condition.toString());
            }
            return sql.toString();
        }
    }
}