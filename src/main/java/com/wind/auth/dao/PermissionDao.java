package com.wind.auth.dao;

import com.wind.auth.model.Permission;
import com.wind.common.Page;
import com.wind.annotation.DAO;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.jdbc.SQL;
import java.util.Map;

/**
 * PermissionDao
 * 权限表
 */
@DAO(catalog = "auth")
public interface PermissionDao {

    /**
     * 表名
     */
    String TABLE_NAME = "permission";

    /**
     * 列名
     */
    String COLLOMN = "id, name, value, status, create_time, update_time";


    /**
     * 查询语句
     */
    String SELECT_SQL = "SELECT " + COLLOMN + " FROM permission";

    /**
     * 新增
     */
    @InsertProvider(type=PermissionProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int save(Permission permission );


    /**
     * 更新
     */
    @UpdateProvider(type=PermissionProvider.class, method="updateByPrimaryKeySelective")
    int update(Permission permission);

    /**
     * 删除
     */
    @Delete("DELETE FROM permission WHERE id= #{primary}")
    int delete(Long primary);

    /**
    * 根据主键查询
    */
    @Select(SELECT_SQL+ " WHERE id = #{primary} limit 0, 1")
    Permission getByPrimary(Long primary );

    /**
     * 统计
     */
    @Select("SELECT COUNT(1) FROM permission")
    int count(Map<String, Object> param);

    public class PermissionProvider {
        public String insertSelective(Permission permission) {
            SQL sql = new SQL();
            sql.INSERT_INTO("permission");

            if (permission.getId() != null) {
                sql.VALUES("id", "#{id}");
            }
            if (permission.getName() != null) {
                sql.VALUES("name", "#{name}");
            }
            if (permission.getValue() != null) {
                sql.VALUES("value", "#{value}");
            }
            if (permission.getStatus() != null) {
                sql.VALUES("status", "#{status}");
            }
            if (permission.getCreateTime() != null) {
                sql.VALUES("create_time", "#{createTime}");
            }
            if (permission.getUpdateTime() != null) {
                sql.VALUES("update_time", "#{updateTime}");
            }

            return sql.toString();
        }

        public String updateByPrimaryKeySelective(Permission permission) {
            SQL sql = new SQL();
            sql.UPDATE("permission");
            if (permission.getId() != null) {
                sql.SET("id = #{id}");
            }
            if (permission.getName() != null) {
                sql.SET("name = #{name}");
            }
            if (permission.getValue() != null) {
                sql.SET("value = #{value}");
            }
            if (permission.getStatus() != null) {
                sql.SET("status = #{status}");
            }
            if (permission.getCreateTime() != null) {
                sql.SET("create_time = #{createTime}");
            }
            if (permission.getUpdateTime() != null) {
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
            if (condition.length() == 0 && param.get("value") != null) {
                condition.append(" value = #{value} ");
            } else if (condition.length() > 0 && param.get("value") != null) {
                condition.append(" and value = #{value} ");
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
            if (condition.length() == 0 && param.get("value") != null) {
                condition.append(" value = #{value} ");
            } else if (condition.length() > 0 && param.get("value") != null) {
                condition.append(" and value = #{value} ");
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