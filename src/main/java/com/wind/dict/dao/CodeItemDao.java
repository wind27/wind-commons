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
    String COLLOMN = "id, code_set, parent_code, code_name, code_value, zh_spell, zh_spell_short, sn, remark, status, create_user, update_user, create_time, update_time, belong";


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
        , @Result(column="code_set",property="codeSet")
        , @Result(column="parent_code",property="parentCode")
        , @Result(column="code_name",property="codeName")
        , @Result(column="code_value",property="codeValue")
        , @Result(column="zh_spell",property="zhSpell")
        , @Result(column="zh_spell_short",property="zhSpellShort")
        , @Result(column="sn",property="sn")
        , @Result(column="remark",property="remark")
        , @Result(column="status",property="status")
        , @Result(column="create_user",property="createUser")
        , @Result(column="update_user",property="updateUser")
        , @Result(column="create_time",property="createTime")
        , @Result(column="update_time",property="updateTime")
        , @Result(column="belong",property="belong")
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
            if (codeItem.getCodeSet() != null) {
                sql.VALUES("code_set", "#{codeSet}");
            }
            if (codeItem.getParentCode() != null) {
                sql.VALUES("parent_code", "#{parentCode}");
            }
            if (codeItem.getCodeName() != null) {
                sql.VALUES("code_name", "#{codeName}");
            }
            if (codeItem.getCodeValue() != null) {
                sql.VALUES("code_value", "#{codeValue}");
            }
            if (codeItem.getZhSpell() != null) {
                sql.VALUES("zh_spell", "#{zhSpell}");
            }
            if (codeItem.getZhSpellShort() != null) {
                sql.VALUES("zh_spell_short", "#{zhSpellShort}");
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
            if (codeItem.getCreateUser() != null) {
                sql.VALUES("create_user", "#{createUser}");
            }
            if (codeItem.getUpdateUser() != null) {
                sql.VALUES("update_user", "#{updateUser}");
            }
            if (codeItem.getCreateTime() != null) {
                sql.VALUES("create_time", "#{createTime}");
            }
            if (codeItem.getUpdateTime() != null) {
                sql.VALUES("update_time", "#{updateTime}");
            }
            if (codeItem.getBelong() != null) {
                sql.VALUES("belong", "#{belong}");
            }

            return sql.toString();
        }

        public String updateByPrimaryKeySelective(CodeItem codeItem) {
            SQL sql = new SQL();
            sql.UPDATE("code_item");
            if (codeItem.getId() != null) {
                sql.SET("id = #{id}");
            }
            if (codeItem.getCodeSet() != null) {
                sql.SET("code_set = #{codeSet}");
            }
            if (codeItem.getParentCode() != null) {
                sql.SET("parent_code = #{parentCode}");
            }
            if (codeItem.getCodeName() != null) {
                sql.SET("code_name = #{codeName}");
            }
            if (codeItem.getCodeValue() != null) {
                sql.SET("code_value = #{codeValue}");
            }
            if (codeItem.getZhSpell() != null) {
                sql.SET("zh_spell = #{zhSpell}");
            }
            if (codeItem.getZhSpellShort() != null) {
                sql.SET("zh_spell_short = #{zhSpellShort}");
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
            if (codeItem.getCreateUser() != null) {
                sql.SET("create_user = #{createUser}");
            }
            if (codeItem.getUpdateUser() != null) {
                sql.SET("update_user = #{updateUser}");
            }
            if (codeItem.getCreateTime() != null) {
                sql.SET("create_time = #{createTime}");
            }
            if (codeItem.getUpdateTime() != null) {
                sql.SET("update_time = #{updateTime}");
            }
            if (codeItem.getBelong() != null) {
                sql.SET("belong = #{belong}");
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
            if (condition.length() == 0 && param.get("codeSet") != null) {
                condition.append(" code_set = #{codeSet} ");
            } else if (condition.length() > 0 && param.get("codeSet") != null) {
                condition.append(" and code_set = #{codeSet} ");
            }
            if (condition.length() == 0 && param.get("parentCode") != null) {
                condition.append(" parent_code = #{parentCode} ");
            } else if (condition.length() > 0 && param.get("parentCode") != null) {
                condition.append(" and parent_code = #{parentCode} ");
            }
            if (condition.length() == 0 && param.get("codeName") != null) {
                condition.append(" code_name = #{codeName} ");
            } else if (condition.length() > 0 && param.get("codeName") != null) {
                condition.append(" and code_name = #{codeName} ");
            }
            if (condition.length() == 0 && param.get("codeValue") != null) {
                condition.append(" code_value = #{codeValue} ");
            } else if (condition.length() > 0 && param.get("codeValue") != null) {
                condition.append(" and code_value = #{codeValue} ");
            }
            if (condition.length() == 0 && param.get("zhSpell") != null) {
                condition.append(" zh_spell = #{zhSpell} ");
            } else if (condition.length() > 0 && param.get("zhSpell") != null) {
                condition.append(" and zh_spell = #{zhSpell} ");
            }
            if (condition.length() == 0 && param.get("zhSpellShort") != null) {
                condition.append(" zh_spell_short = #{zhSpellShort} ");
            } else if (condition.length() > 0 && param.get("zhSpellShort") != null) {
                condition.append(" and zh_spell_short = #{zhSpellShort} ");
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
            if (condition.length() == 0 && param.get("createUser") != null) {
                condition.append(" create_user = #{createUser} ");
            } else if (condition.length() > 0 && param.get("createUser") != null) {
                condition.append(" and create_user = #{createUser} ");
            }
            if (condition.length() == 0 && param.get("updateUser") != null) {
                condition.append(" update_user = #{updateUser} ");
            } else if (condition.length() > 0 && param.get("updateUser") != null) {
                condition.append(" and update_user = #{updateUser} ");
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
            if (condition.length() == 0 && param.get("belong") != null) {
                condition.append(" belong = #{belong} ");
            } else if (condition.length() > 0 && param.get("belong") != null) {
                condition.append(" and belong = #{belong} ");
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
            if (condition.length() == 0 && param.get("codeSet") != null) {
                condition.append(" code_set = #{codeSet} ");
            } else if (condition.length() > 0 && param.get("codeSet") != null) {
                condition.append(" and code_set = #{codeSet} ");
            }
            if (condition.length() == 0 && param.get("parentCode") != null) {
                condition.append(" parent_code = #{parentCode} ");
            } else if (condition.length() > 0 && param.get("parentCode") != null) {
                condition.append(" and parent_code = #{parentCode} ");
            }
            if (condition.length() == 0 && param.get("codeName") != null) {
                condition.append(" code_name = #{codeName} ");
            } else if (condition.length() > 0 && param.get("codeName") != null) {
                condition.append(" and code_name = #{codeName} ");
            }
            if (condition.length() == 0 && param.get("codeValue") != null) {
                condition.append(" code_value = #{codeValue} ");
            } else if (condition.length() > 0 && param.get("codeValue") != null) {
                condition.append(" and code_value = #{codeValue} ");
            }
            if (condition.length() == 0 && param.get("zhSpell") != null) {
                condition.append(" zh_spell = #{zhSpell} ");
            } else if (condition.length() > 0 && param.get("zhSpell") != null) {
                condition.append(" and zh_spell = #{zhSpell} ");
            }
            if (condition.length() == 0 && param.get("zhSpellShort") != null) {
                condition.append(" zh_spell_short = #{zhSpellShort} ");
            } else if (condition.length() > 0 && param.get("zhSpellShort") != null) {
                condition.append(" and zh_spell_short = #{zhSpellShort} ");
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
            if (condition.length() == 0 && param.get("createUser") != null) {
                condition.append(" create_user = #{createUser} ");
            } else if (condition.length() > 0 && param.get("createUser") != null) {
                condition.append(" and create_user = #{createUser} ");
            }
            if (condition.length() == 0 && param.get("updateUser") != null) {
                condition.append(" update_user = #{updateUser} ");
            } else if (condition.length() > 0 && param.get("updateUser") != null) {
                condition.append(" and update_user = #{updateUser} ");
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
            if (condition.length() == 0 && param.get("belong") != null) {
                condition.append(" belong = #{belong} ");
            } else if (condition.length() > 0 && param.get("belong") != null) {
                condition.append(" and belong = #{belong} ");
            }
            sql.FROM(TABLE_NAME);
            if (condition.length() > 0) {
                sql.WHERE(condition.toString());
            }
            return sql.toString();
        }
    }
}