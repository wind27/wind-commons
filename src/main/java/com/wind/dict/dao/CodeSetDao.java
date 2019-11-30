package com.wind.dict.dao;

import com.wind.dict.model.CodeSet;
import com.wind.common.Page;
import com.wind.annotation.DAO;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.jdbc.SQL;
import java.util.Map;

/**
 * CodeSetDao
 * 
 */
@DAO(catalog = "dict")
public interface CodeSetDao {

    /**
     * 表名
     */
    String TABLE_NAME = "code_set";

    /**
     * 列名
     */
    String COLLOMN = "id, code_namespace_id, name, key, remark, sn, status, is_export_js, create_account_id, update_account_id, create_time, update_time";


    /**
     * 查询语句
     */
    String SELECT_SQL = "SELECT " + COLLOMN + " FROM code_set ";

    /**
     * 新增
     */
    @InsertProvider(type=CodeSetProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int save(CodeSet codeSet );


    /**
     * 更新
     */
    @UpdateProvider(type=CodeSetProvider.class, method="updateByPrimaryKeySelective")
    int update(CodeSet codeSet);

    /**
     * 删除
     */
    @Delete("DELETE FROM code_set WHERE id= #{primary}")
    int delete(Long primary);

    /**
    * 根据主键查询
    */
    @Select(SELECT_SQL+ " WHERE id = #{primary} limit 0, 1")
    @Results(id = "codeSetResult", value={
        @Result(column="id",property="id")
        , @Result(column="code_namespace_id",property="codeNamespaceId")
        , @Result(column="name",property="name")
        , @Result(column="key",property="key")
        , @Result(column="remark",property="remark")
        , @Result(column="sn",property="sn")
        , @Result(column="status",property="status")
        , @Result(column="is_export_js",property="isExportJs")
        , @Result(column="create_account_id",property="createAccountId")
        , @Result(column="update_account_id",property="updateAccountId")
        , @Result(column="create_time",property="createTime")
        , @Result(column="update_time",property="updateTime")
    })
    CodeSet getByPrimary(Long primary );

    /**
     * 统计
     */
    @Select("SELECT COUNT(1) FROM code_set")
    int count(Map<String, Object> param);

    public class CodeSetProvider {
        public String insertSelective(CodeSet codeSet) {
            SQL sql = new SQL();
            sql.INSERT_INTO("code_set");

            if (codeSet.getId() != null) {
                sql.VALUES("id", "#{id}");
            }
            if (codeSet.getCodeNamespaceId() != null) {
                sql.VALUES("code_namespace_id", "#{codeNamespaceId}");
            }
            if (codeSet.getName() != null) {
                sql.VALUES("name", "#{name}");
            }
            if (codeSet.getKey() != null) {
                sql.VALUES("key", "#{key}");
            }
            if (codeSet.getRemark() != null) {
                sql.VALUES("remark", "#{remark}");
            }
            if (codeSet.getSn() != null) {
                sql.VALUES("sn", "#{sn}");
            }
            if (codeSet.getStatus() != null) {
                sql.VALUES("status", "#{status}");
            }
            if (codeSet.getIsExportJs() != null) {
                sql.VALUES("is_export_js", "#{isExportJs}");
            }
            if (codeSet.getCreateAccountId() != null) {
                sql.VALUES("create_account_id", "#{createAccountId}");
            }
            if (codeSet.getUpdateAccountId() != null) {
                sql.VALUES("update_account_id", "#{updateAccountId}");
            }
            if (codeSet.getCreateTime() != null) {
                sql.VALUES("create_time", "#{createTime}");
            }
            if (codeSet.getUpdateTime() != null) {
                sql.VALUES("update_time", "#{updateTime}");
            }

            return sql.toString();
        }

        public String updateByPrimaryKeySelective(CodeSet codeSet) {
            SQL sql = new SQL();
            sql.UPDATE("code_set");
            if (codeSet.getId() != null) {
                sql.SET("id = #{id}");
            }
            if (codeSet.getCodeNamespaceId() != null) {
                sql.SET("code_namespace_id = #{codeNamespaceId}");
            }
            if (codeSet.getName() != null) {
                sql.SET("name = #{name}");
            }
            if (codeSet.getKey() != null) {
                sql.SET("key = #{key}");
            }
            if (codeSet.getRemark() != null) {
                sql.SET("remark = #{remark}");
            }
            if (codeSet.getSn() != null) {
                sql.SET("sn = #{sn}");
            }
            if (codeSet.getStatus() != null) {
                sql.SET("status = #{status}");
            }
            if (codeSet.getIsExportJs() != null) {
                sql.SET("is_export_js = #{isExportJs}");
            }
            if (codeSet.getCreateAccountId() != null) {
                sql.SET("create_account_id = #{createAccountId}");
            }
            if (codeSet.getUpdateAccountId() != null) {
                sql.SET("update_account_id = #{updateAccountId}");
            }
            if (codeSet.getCreateTime() != null) {
                sql.SET("create_time = #{createTime}");
            }
            if (codeSet.getUpdateTime() != null) {
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
            if (condition.length() == 0 && param.get("codeNamespaceId") != null) {
                condition.append(" code_namespace_id = #{codeNamespaceId} ");
            } else if (condition.length() > 0 && param.get("codeNamespaceId") != null) {
                condition.append(" and code_namespace_id = #{codeNamespaceId} ");
            }
            if (condition.length() == 0 && param.get("name") != null) {
                condition.append(" name = #{name} ");
            } else if (condition.length() > 0 && param.get("name") != null) {
                condition.append(" and name = #{name} ");
            }
            if (condition.length() == 0 && param.get("key") != null) {
                condition.append(" key = #{key} ");
            } else if (condition.length() > 0 && param.get("key") != null) {
                condition.append(" and key = #{key} ");
            }
            if (condition.length() == 0 && param.get("remark") != null) {
                condition.append(" remark = #{remark} ");
            } else if (condition.length() > 0 && param.get("remark") != null) {
                condition.append(" and remark = #{remark} ");
            }
            if (condition.length() == 0 && param.get("sn") != null) {
                condition.append(" sn = #{sn} ");
            } else if (condition.length() > 0 && param.get("sn") != null) {
                condition.append(" and sn = #{sn} ");
            }
            if (condition.length() == 0 && param.get("status") != null) {
                condition.append(" status = #{status} ");
            } else if (condition.length() > 0 && param.get("status") != null) {
                condition.append(" and status = #{status} ");
            }
            if (condition.length() == 0 && param.get("isExportJs") != null) {
                condition.append(" is_export_js = #{isExportJs} ");
            } else if (condition.length() > 0 && param.get("isExportJs") != null) {
                condition.append(" and is_export_js = #{isExportJs} ");
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
            if (condition.length() == 0 && param.get("codeNamespaceId") != null) {
                condition.append(" code_namespace_id = #{codeNamespaceId} ");
            } else if (condition.length() > 0 && param.get("codeNamespaceId") != null) {
                condition.append(" and code_namespace_id = #{codeNamespaceId} ");
            }
            if (condition.length() == 0 && param.get("name") != null) {
                condition.append(" name = #{name} ");
            } else if (condition.length() > 0 && param.get("name") != null) {
                condition.append(" and name = #{name} ");
            }
            if (condition.length() == 0 && param.get("key") != null) {
                condition.append(" key = #{key} ");
            } else if (condition.length() > 0 && param.get("key") != null) {
                condition.append(" and key = #{key} ");
            }
            if (condition.length() == 0 && param.get("remark") != null) {
                condition.append(" remark = #{remark} ");
            } else if (condition.length() > 0 && param.get("remark") != null) {
                condition.append(" and remark = #{remark} ");
            }
            if (condition.length() == 0 && param.get("sn") != null) {
                condition.append(" sn = #{sn} ");
            } else if (condition.length() > 0 && param.get("sn") != null) {
                condition.append(" and sn = #{sn} ");
            }
            if (condition.length() == 0 && param.get("status") != null) {
                condition.append(" status = #{status} ");
            } else if (condition.length() > 0 && param.get("status") != null) {
                condition.append(" and status = #{status} ");
            }
            if (condition.length() == 0 && param.get("isExportJs") != null) {
                condition.append(" is_export_js = #{isExportJs} ");
            } else if (condition.length() > 0 && param.get("isExportJs") != null) {
                condition.append(" and is_export_js = #{isExportJs} ");
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