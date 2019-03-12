package com.wind.auth.dao;

import com.wind.auth.model.User;
import com.wind.common.Page;
import com.wind.annotation.DAO;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.jdbc.SQL;
import java.util.Map;

/**
 * UserDao
 * 用户表
 */
@DAO(catalog = "auth")
public interface UserDao {

    /**
     * 表名
     */
    String TABLE_NAME = "user";

    /**
     * 列名
     */
    String COLLOMN = "id, username, realname, salt, password, status, create_time, update_time, mobile, idcard, email";


    /**
     * 查询语句
     */
    String SELECT_SQL = "SELECT " + COLLOMN + " FROM user";

    /**
     * 新增
     */
    @InsertProvider(type=UserProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int save(User user );


    /**
     * 更新
     */
    @UpdateProvider(type=UserProvider.class, method="updateByPrimaryKeySelective")
    int update(User user);

    /**
     * 删除
     */
    @Delete("DELETE FROM user WHERE id= #{primary}")
    int delete(Long primary);

    /**
    * 根据主键查询
    */
    @Select(SELECT_SQL+ " WHERE id = #{primary} limit 0, 1")
    User getByPrimary(Long primary );

    /**
     * 统计
     */
    @Select("SELECT COUNT(1) FROM user")
    int count(Map<String, Object> param);

    public class UserProvider {
        public String insertSelective(User user) {
            SQL sql = new SQL();
            sql.INSERT_INTO("user");

            if (user.getId() != null) {
                sql.VALUES("id", "#{id}");
            }
            if (user.getUsername() != null) {
                sql.VALUES("username", "#{username}");
            }
            if (user.getRealname() != null) {
                sql.VALUES("realname", "#{realname}");
            }
            if (user.getSalt() != null) {
                sql.VALUES("salt", "#{salt}");
            }
            if (user.getPassword() != null) {
                sql.VALUES("password", "#{password}");
            }
            if (user.getStatus() != null) {
                sql.VALUES("status", "#{status}");
            }
            if (user.getCreateTime() != null) {
                sql.VALUES("create_time", "#{createTime}");
            }
            if (user.getUpdateTime() != null) {
                sql.VALUES("update_time", "#{updateTime}");
            }
            if (user.getMobile() != null) {
                sql.VALUES("mobile", "#{mobile}");
            }
            if (user.getIdcard() != null) {
                sql.VALUES("idcard", "#{idcard}");
            }
            if (user.getEmail() != null) {
                sql.VALUES("email", "#{email}");
            }

            return sql.toString();
        }

        public String updateByPrimaryKeySelective(User user) {
            SQL sql = new SQL();
            sql.UPDATE("user");
            if (user.getId() != null) {
                sql.SET("id = #{id}");
            }
            if (user.getUsername() != null) {
                sql.SET("username = #{username}");
            }
            if (user.getRealname() != null) {
                sql.SET("realname = #{realname}");
            }
            if (user.getSalt() != null) {
                sql.SET("salt = #{salt}");
            }
            if (user.getPassword() != null) {
                sql.SET("password = #{password}");
            }
            if (user.getStatus() != null) {
                sql.SET("status = #{status}");
            }
            if (user.getCreateTime() != null) {
                sql.SET("create_time = #{createTime}");
            }
            if (user.getUpdateTime() != null) {
                sql.SET("update_time = #{updateTime}");
            }
            if (user.getMobile() != null) {
                sql.SET("mobile = #{mobile}");
            }
            if (user.getIdcard() != null) {
                sql.SET("idcard = #{idcard}");
            }
            if (user.getEmail() != null) {
                sql.SET("email = #{email}");
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
            if (condition.length() == 0 && param.get("username") != null) {
                condition.append(" username = #{username} ");
            } else if (condition.length() > 0 && param.get("username") != null) {
                condition.append(" and username = #{username} ");
            }
            if (condition.length() == 0 && param.get("realname") != null) {
                condition.append(" realname = #{realname} ");
            } else if (condition.length() > 0 && param.get("realname") != null) {
                condition.append(" and realname = #{realname} ");
            }
            if (condition.length() == 0 && param.get("salt") != null) {
                condition.append(" salt = #{salt} ");
            } else if (condition.length() > 0 && param.get("salt") != null) {
                condition.append(" and salt = #{salt} ");
            }
            if (condition.length() == 0 && param.get("password") != null) {
                condition.append(" password = #{password} ");
            } else if (condition.length() > 0 && param.get("password") != null) {
                condition.append(" and password = #{password} ");
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
            if (condition.length() == 0 && param.get("mobile") != null) {
                condition.append(" mobile = #{mobile} ");
            } else if (condition.length() > 0 && param.get("mobile") != null) {
                condition.append(" and mobile = #{mobile} ");
            }
            if (condition.length() == 0 && param.get("idcard") != null) {
                condition.append(" idcard = #{idcard} ");
            } else if (condition.length() > 0 && param.get("idcard") != null) {
                condition.append(" and idcard = #{idcard} ");
            }
            if (condition.length() == 0 && param.get("email") != null) {
                condition.append(" email = #{email} ");
            } else if (condition.length() > 0 && param.get("email") != null) {
                condition.append(" and email = #{email} ");
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
            if (condition.length() == 0 && param.get("username") != null) {
                condition.append(" username = #{username} ");
            } else if (condition.length() > 0 && param.get("username") != null) {
                condition.append(" and username = #{username} ");
            }
            if (condition.length() == 0 && param.get("realname") != null) {
                condition.append(" realname = #{realname} ");
            } else if (condition.length() > 0 && param.get("realname") != null) {
                condition.append(" and realname = #{realname} ");
            }
            if (condition.length() == 0 && param.get("salt") != null) {
                condition.append(" salt = #{salt} ");
            } else if (condition.length() > 0 && param.get("salt") != null) {
                condition.append(" and salt = #{salt} ");
            }
            if (condition.length() == 0 && param.get("password") != null) {
                condition.append(" password = #{password} ");
            } else if (condition.length() > 0 && param.get("password") != null) {
                condition.append(" and password = #{password} ");
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
            if (condition.length() == 0 && param.get("mobile") != null) {
                condition.append(" mobile = #{mobile} ");
            } else if (condition.length() > 0 && param.get("mobile") != null) {
                condition.append(" and mobile = #{mobile} ");
            }
            if (condition.length() == 0 && param.get("idcard") != null) {
                condition.append(" idcard = #{idcard} ");
            } else if (condition.length() > 0 && param.get("idcard") != null) {
                condition.append(" and idcard = #{idcard} ");
            }
            if (condition.length() == 0 && param.get("email") != null) {
                condition.append(" email = #{email} ");
            } else if (condition.length() > 0 && param.get("email") != null) {
                condition.append(" and email = #{email} ");
            }
            sql.FROM(TABLE_NAME);
            if (condition.length() > 0) {
                sql.WHERE(condition.toString());
            }
            return sql.toString();
        }
    }
}