package com.wind.dict.dao;

import com.wind.dict.model.CodeItem;
import com.wind.common.Page;
import com.wind.annotation.DAO;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.jdbc.SQL;
import java.util.Map;

/**
 * CodeItemDao
 * 
 */
@DAO(catalog = "dict")
public interface CodeItemDao {

    /**
     * 表名
     */
    String TABLE_NAME = "code_item";

    /**
     * 列名
     */
    String COLLOMN = "id, code_namespace_id, code_set_key, key, value, sn, remark, status, create_account_id, update_account_id, create_time, update_time";


    /**
     * 查询语句
     */
    String SELECT_SQL = "SELECT " + COLLOMN + " FROM code_item ";

    /**
     * 新增
     */
    @InsertProvider(type=CodeItemProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int save(CodeItem codeItem );


    /**
     * 更新
     */
    @UpdateProvider(type=CodeItemProvider.class, method="updateByPrimaryKeySelective")
    int update(CodeItem codeItem);

    /**
     * 删除
     */
    @Delete("DELETE FROM code_item WHERE id= #{primary}")
    int delete(Long primary);

    /**
    * 根据主键查询
    */
    @Select(SELECT_SQL+ " WHERE id = #{primary} limit 0, 1")
    @Results(id = "codeItemResult", value={
        @Result(column="id",property="id")
        , @Result(column="code_namespace_id",property="codeNamespaceId")
        , @Result(column="code_set_key",property="codeSetKey")
        , @Result(column="key",property="key")
        , @Result(column="value",property="value")
        , @Result(column="sn",property="sn")
        , @Result(column="remark",property="remark")
        , @Result(column="status",property="status")
        , @Result(column="create_account_id",property="createAccountId")
        , @Result(column="update_account_id",property="updateAccountId")
        , @Result(column="create_time",property="createTime")
        , @Result(column="update_time",property="updateTime")
    })
    CodeItem getByPrimary(Long primary );

    /**
     * 统计
     */
    @Select("SELECT COUNT(1) FROM code_item")
    int count(Map<String, Object> param);

    public class CodeItemProvider {
        public String insertSelective(CodeItem codeItem) {
            SQL sql = new SQL();
            sql.INSERT_INTO("code_item");

            if (codeItem.getId() != null) {
                sql.VALUES("id", "#{id}");
            }
            if (codeItem.getCodeNamespaceId() != null) {
                sql.VALUES("code_namespace_id", "#{codeNamespaceId}");
            }
            if (codeItem.getCodeSetKey() != null) {
                sql.VALUES("code_set_key", "#{codeSetKey}");
            }
            if (codeItem.getKey() != null) {
                sql.VALUES("key", "#{key}");
            }
            if (codeItem.getValue() != null) {
                sql.VALUES("value", "#{value}");
            }
            if (codeItem.getSn() != null) {
                sql.VALUES("sn", "#{sn}");
            }
            if (codeItem.getRemark() != null) {
                sql.VALUES("remark", "#{remark}");
            }
            if (codeItem.getStatus() != null) {
                sql.VALUES("status", "#{status}");
            }
            if (codeItem.getCreateAccountId() != null) {
                sql.VALUES("create_account_id", "#{createAccountId}");
            }
            if (codeItem.getUpdateAccountId() != null) {
                sql.VALUES("update_account_id", "#{updateAccountId}");
            }
            if (codeItem.getCreateTime() != null) {
                sql.VALUES("create_time", "#{createTime}");
            }
            if (codeItem.getUpdateTime() != null) {
                sql.VALUES("update_time", "#{updateTime}");
            }

            return sql.toString();
        }

        public String updateByPrimaryKeySelective(CodeItem codeItem) {
            SQL sql = new SQL();
            sql.UPDATE("code_item");
            if (codeItem.getId() != null) {
                sql.SET("id = #{id}");
            }
            if (codeItem.getCodeNamespaceId() != null) {
                sql.SET("code_namespace_id = #{codeNamespaceId}");
            }
            if (codeItem.getCodeSetKey() != null) {
                sql.SET("code_set_key = #{codeSetKey}");
            }
            if (codeItem.getKey() != null) {
                sql.SET("key = #{key}");
            }
            if (codeItem.getValue() != null) {
                sql.SET("value = #{value}");
            }
            if (codeItem.getSn() != null) {
                sql.SET("sn = #{sn}");
            }
            if (codeItem.getRemark() != null) {
                sql.SET("remark = #{remark}");
            }
            if (codeItem.getStatus() != null) {
                sql.SET("status = #{status}");
            }
            if (codeItem.getCreateAccountId() != null) {
                sql.SET("create_account_id = #{createAccountId}");
            }
            if (codeItem.getUpdateAccountId() != null) {
                sql.SET("update_account_id = #{updateAccountId}");
            }
            if (codeItem.getCreateTime() != null) {
                sql.SET("create_time = #{createTime}");
            }
            if (codeItem.getUpdateTime() != null) {
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
            if (condition.length() == 0 && param.get("codeSetKey") != null) {
                condition.append(" code_set_key = #{codeSetKey} ");
            } else if (condition.length() > 0 && param.get("codeSetKey") != null) {
                condition.append(" and code_set_key = #{codeSetKey} ");
            }
            if (condition.length() == 0 && param.get("key") != null) {
                condition.append(" key = #{key} ");
            } else if (condition.length() > 0 && param.get("key") != null) {
                condition.append(" and key = #{key} ");
            }
            if (condition.length() == 0 && param.get("value") != null) {
                condition.append(" value = #{value} ");
            } else if (condition.length() > 0 && param.get("value") != null) {
                condition.append(" and value = #{value} ");
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
            if (condition.length() == 0 && param.get("codeNamespaceId") != null) {
                condition.append(" code_namespace_id = #{codeNamespaceId} ");
            } else if (condition.length() > 0 && param.get("codeNamespaceId") != null) {
                condition.append(" and code_namespace_id = #{codeNamespaceId} ");
            }
            if (condition.length() == 0 && param.get("codeSetKey") != null) {
                condition.append(" code_set_key = #{codeSetKey} ");
            } else if (condition.length() > 0 && param.get("codeSetKey") != null) {
                condition.append(" and code_set_key = #{codeSetKey} ");
            }
            if (condition.length() == 0 && param.get("key") != null) {
                condition.append(" key = #{key} ");
            } else if (condition.length() > 0 && param.get("key") != null) {
                condition.append(" and key = #{key} ");
            }
            if (condition.length() == 0 && param.get("value") != null) {
                condition.append(" value = #{value} ");
            } else if (condition.length() > 0 && param.get("value") != null) {
                condition.append(" and value = #{value} ");
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