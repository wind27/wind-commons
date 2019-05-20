package com.wind.auth.dao;

import com.wind.auth.model.UserToken;
import com.wind.common.Page;
import com.wind.annotation.DAO;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.jdbc.SQL;
import java.util.Map;

/**
 * UserTokenDao
 * ç”¨æˆ·ç™»å½•token
 */
@DAO(catalog = "auth")
public interface UserTokenDao {

    /**
     * 表名
     */
    String TABLE_NAME = "user_token";

    /**
     * 列名
     */
    String COLLOMN = "id, user_id, token, client_ip, create_time";


    /**
     * 查询语句
     */
    String SELECT_SQL = "SELECT " + COLLOMN + " FROM user_token";

    /**
     * 新增
     */
    @InsertProvider(type=UserTokenProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int save(UserToken userToken );


    /**
     * 更新
     */
    @UpdateProvider(type=UserTokenProvider.class, method="updateByPrimaryKeySelective")
    int update(UserToken userToken);

    /**
     * 删除
     */
    @Delete("DELETE FROM user_token WHERE id= #{primary}")
    int delete(Long primary);

    /**
    * 根据主键查询
    */
    @Select(SELECT_SQL+ " WHERE id = #{primary} limit 0, 1")
    UserToken getByPrimary(Long primary );

    /**
     * 统计
     */
    @Select("SELECT COUNT(1) FROM user_token")
    int count(Map<String, Object> param);

    public class UserTokenProvider {
        public String insertSelective(UserToken userToken) {
            SQL sql = new SQL();
            sql.INSERT_INTO("user_token");

            if (userToken.getId() != null) {
                sql.VALUES("id", "#{id}");
            }
            if (userToken.getUserId() != null) {
                sql.VALUES("user_id", "#{userId}");
            }
            if (userToken.getToken() != null) {
                sql.VALUES("token", "#{token}");
            }
            if (userToken.getClientIp() != null) {
                sql.VALUES("client_ip", "#{clientIp}");
            }
            if (userToken.getCreateTime() != null) {
                sql.VALUES("create_time", "#{createTime}");
            }

            return sql.toString();
        }

        public String updateByPrimaryKeySelective(UserToken userToken) {
            SQL sql = new SQL();
            sql.UPDATE("user_token");
            if (userToken.getId() != null) {
                sql.SET("id = #{id}");
            }
            if (userToken.getUserId() != null) {
                sql.SET("user_id = #{userId}");
            }
            if (userToken.getToken() != null) {
                sql.SET("token = #{token}");
            }
            if (userToken.getClientIp() != null) {
                sql.SET("client_ip = #{clientIp}");
            }
            if (userToken.getCreateTime() != null) {
                sql.SET("create_time = #{createTime}");
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
            if (condition.length() == 0 && param.get("userId") != null) {
                condition.append(" user_id = #{userId} ");
            } else if (condition.length() > 0 && param.get("userId") != null) {
                condition.append(" and user_id = #{userId} ");
            }
            if (condition.length() == 0 && param.get("token") != null) {
                condition.append(" token = #{token} ");
            } else if (condition.length() > 0 && param.get("token") != null) {
                condition.append(" and token = #{token} ");
            }
            if (condition.length() == 0 && param.get("clientIp") != null) {
                condition.append(" client_ip = #{clientIp} ");
            } else if (condition.length() > 0 && param.get("clientIp") != null) {
                condition.append(" and client_ip = #{clientIp} ");
            }
            if (condition.length() == 0 && param.get("createTime") != null) {
                condition.append(" create_time = #{createTime} ");
            } else if (condition.length() > 0 && param.get("createTime") != null) {
                condition.append(" and create_time = #{createTime} ");
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
            if (condition.length() == 0 && param.get("userId") != null) {
                condition.append(" user_id = #{userId} ");
            } else if (condition.length() > 0 && param.get("userId") != null) {
                condition.append(" and user_id = #{userId} ");
            }
            if (condition.length() == 0 && param.get("token") != null) {
                condition.append(" token = #{token} ");
            } else if (condition.length() > 0 && param.get("token") != null) {
                condition.append(" and token = #{token} ");
            }
            if (condition.length() == 0 && param.get("clientIp") != null) {
                condition.append(" client_ip = #{clientIp} ");
            } else if (condition.length() > 0 && param.get("clientIp") != null) {
                condition.append(" and client_ip = #{clientIp} ");
            }
            if (condition.length() == 0 && param.get("createTime") != null) {
                condition.append(" create_time = #{createTime} ");
            } else if (condition.length() > 0 && param.get("createTime") != null) {
                condition.append(" and create_time = #{createTime} ");
            }
            sql.FROM(TABLE_NAME);
            if (condition.length() > 0) {
                sql.WHERE(condition.toString());
            }
            return sql.toString();
        }
    }
}