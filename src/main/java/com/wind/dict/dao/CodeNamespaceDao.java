package com.wind.dict.dao;

import com.wind.dict.model.CodeNamespace;
import com.wind.common.Page;
import com.wind.annotation.DAO;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.jdbc.SQL;
import java.util.Map;

/**
 * CodeNamespaceDao
 * 
 */
@DAO(catalog = "dict")
public interface CodeNamespaceDao {

    /**
     * 表名
     */
    String TABLE_NAME = "code_namespace";

    /**
     * 列名
     */
    String COLLOMN = "id, name, sn, remark, status, create_account_id, update_account_id, create_time, update_time";


    /**
     * 查询语句
     */
    String SELECT_SQL = "SELECT " + COLLOMN + " FROM code_namespace ";

    /**
     * 新增
     */
    @InsertProvider(type=CodeNamespaceProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int save(CodeNamespace codeNamespace );


    /**
     * 更新
     */
    @UpdateProvider(type=CodeNamespaceProvider.class, method="updateByPrimaryKeySelective")
    int update(CodeNamespace codeNamespace);

    /**
     * 删除
     */
    @Delete("DELETE FROM code_namespace WHERE id= #{primary}")
    int delete(Long primary);

    /**
    * 根据主键查询
    */
    @Select(SELECT_SQL+ " WHERE id = #{primary} limit 0, 1")
    @Results(id = "codeNamespaceResult", value={
        @Result(column="id",property="id")
        , @Result(column="name",property="name")
        , @Result(column="sn",property="sn")
        , @Result(column="remark",property="remark")
        , @Result(column="status",property="status")
        , @Result(column="create_account_id",property="createAccountId")
        , @Result(column="update_account_id",property="updateAccountId")
        , @Result(column="create_time",property="createTime")
        , @Result(column="update_time",property="updateTime")
    })
    CodeNamespace getByPrimary(Long primary );

    /**
     * 统计
     */
    @Select("SELECT COUNT(1) FROM code_namespace")
    int count(Map<String, Object> param);

    public class CodeNamespaceProvider {
        public String insertSelective(CodeNamespace codeNamespace) {
            SQL sql = new SQL();
            sql.INSERT_INTO("code_namespace");

            if (codeNamespace.getId() != null) {
                sql.VALUES("id", "#{id}");
            }
            if (codeNamespace.getName() != null) {
                sql.VALUES("name", "#{name}");
            }
            if (codeNamespace.getSn() != null) {
                sql.VALUES("sn", "#{sn}");
            }
            if (codeNamespace.getRemark() != null) {
                sql.VALUES("remark", "#{remark}");
            }
            if (codeNamespace.getStatus() != null) {
                sql.VALUES("status", "#{status}");
            }
            if (codeNamespace.getCreateAccountId() != null) {
                sql.VALUES("create_account_id", "#{createAccountId}");
            }
            if (codeNamespace.getUpdateAccountId() != null) {
                sql.VALUES("update_account_id", "#{updateAccountId}");
            }
            if (codeNamespace.getCreateTime() != null) {
                sql.VALUES("create_time", "#{createTime}");
            }
            if (codeNamespace.getUpdateTime() != null) {
                sql.VALUES("update_time", "#{updateTime}");
            }

            return sql.toString();
        }

        public String updateByPrimaryKeySelective(CodeNamespace codeNamespace) {
            SQL sql = new SQL();
            sql.UPDATE("code_namespace");
            if (codeNamespace.getId() != null) {
                sql.SET("id = #{id}");
            }
            if (codeNamespace.getName() != null) {
                sql.SET("name = #{name}");
            }
            if (codeNamespace.getSn() != null) {
                sql.SET("sn = #{sn}");
            }
            if (codeNamespace.getRemark() != null) {
                sql.SET("remark = #{remark}");
            }
            if (codeNamespace.getStatus() != null) {
                sql.SET("status = #{status}");
            }
            if (codeNamespace.getCreateAccountId() != null) {
                sql.SET("create_account_id = #{createAccountId}");
            }
            if (codeNamespace.getUpdateAccountId() != null) {
                sql.SET("update_account_id = #{updateAccountId}");
            }
            if (codeNamespace.getCreateTime() != null) {
                sql.SET("create_time = #{createTime}");
            }
            if (codeNamespace.getUpdateTime() != null) {
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
            if (condition.length() == 0 && param.get("sn") != null) {
                condition.append(" sn = #{sn} ");
            } else if (condition.length() > 0 && param.get("sn") != null) {
                condition.append(" and sn = #{sn} ");
            }
            if (condition.length() == 0 && param.get("remark") != null) {
                condition.append(" remark = #{remark} ");
            } else if (condition.length() > 0 && param.get("remark") != null) {
                condition.append(" and remark = #{remark} ");
            }
            if (condition.length() == 0 && param.get("status") != null) {
                condition.append(" status = #{status} ");
            } else if (condition.length() > 0 && param.get("status") != null) {
                condition.append(" and status = #{status} ");
            }
            if (condition.length() == 0 && param.get("createAccountId") != null) {
                condition.append(" create_account_id = #{createAccountId} ");
            } else if (condition.length() > 0 && param.get("createAccountId") != null) {
                condition.append(" and create_account_id = #{createAccountId} ");
            }
            if (condition.length() == 0 && param.get("updateAccountId") != null) {
                condition.append(" update_account_id = #{updateAccountId} ");
            } else if (condition.length() > 0 && param.get("updateAccountId") != null) {
                condition.append(" and update_account_id = #{updateAccountId} ");
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
            if (condition.length() == 0 && param.get("sn") != null) {
                condition.append(" sn = #{sn} ");
            } else if (condition.length() > 0 && param.get("sn") != null) {
                condition.append(" and sn = #{sn} ");
            }
            if (condition.length() == 0 && param.get("remark") != null) {
                condition.append(" remark = #{remark} ");
            } else if (condition.length() > 0 && param.get("remark") != null) {
                condition.append(" and remark = #{remark} ");
            }
            if (condition.length() == 0 && param.get("status") != null) {
                condition.append(" status = #{status} ");
            } else if (condition.length() > 0 && param.get("status") != null) {
                condition.append(" and status = #{status} ");
            }
            if (condition.length() == 0 && param.get("createAccountId") != null) {
                condition.append(" create_account_id = #{createAccountId} ");
            } else if (condition.length() > 0 && param.get("createAccountId") != null) {
                condition.append(" and create_account_id = #{createAccountId} ");
            }
            if (condition.length() == 0 && param.get("updateAccountId") != null) {
                condition.append(" update_account_id = #{updateAccountId} ");
            } else if (condition.length() > 0 && param.get("updateAccountId") != null) {
                condition.append(" and update_account_id = #{updateAccountId} ");
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