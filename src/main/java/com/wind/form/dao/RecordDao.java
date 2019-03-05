package com.wind.form.dao;

import com.wind.form.model.Record;
import com.wind.common.Page;
import com.wind.annotation.DAO;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.jdbc.SQL;
import java.util.Map;

/**
 * RecordDao
 * 表单记录表
 */
@DAO(catalog = "form")
public interface RecordDao {

    /**
     * 表名
     */
    String TABLE_NAME = "record";

    /**
     * 列名
     */
    String COLLOMN = "id, form_id, value, create_time, update_time";


    /**
     * 查询语句
     */
    String SELECT_SQL = "SELECT " + COLLOMN + " FROM record";

    /**
     * 新增
     */
    @InsertProvider(type=RecordProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int save(Record record );


    /**
     * 更新
     */
    @UpdateProvider(type=RecordProvider.class, method="updateByPrimaryKeySelective")
    int update(Record record);

    /**
     * 删除
     */
    @Delete("DELETE FROM record WHERE id= #{primary}")
    int delete(Long primary);

    /**
    * 根据主键查询
    */
    @Select(SELECT_SQL+ " WHERE id = #{primary} limit 0, 1")
    Record getByPrimary(Long primary );

    /**
     * 统计
     */
    @Select("SELECT COUNT(1) FROM record")
    int count(Map<String, Object> param);

    public class RecordProvider {
        public String insertSelective(Record record) {
            SQL sql = new SQL();
            sql.INSERT_INTO("record");

            if (record.getId() != null) {
                sql.VALUES("id", "#{id}");
            }
            if (record.getFormId() != null) {
                sql.VALUES("form_id", "#{formId}");
            }
            if (record.getValue() != null) {
                sql.VALUES("value", "#{value}");
            }
            if (record.getCreateTime() != null) {
                sql.VALUES("create_time", "#{createTime}");
            }
            if (record.getUpdateTime() != null) {
                sql.VALUES("update_time", "#{updateTime}");
            }

            return sql.toString();
        }

        public String updateByPrimaryKeySelective(Record record) {
            SQL sql = new SQL();
            sql.UPDATE("record");
            if (record.getId() != null) {
                sql.SET("id = #{id}");
            }
            if (record.getFormId() != null) {
                sql.SET("form_id = #{formId}");
            }
            if (record.getValue() != null) {
                sql.SET("value = #{value}");
            }
            if (record.getCreateTime() != null) {
                sql.SET("create_time = #{createTime}");
            }
            if (record.getUpdateTime() != null) {
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
            if (condition.length() == 0 && param.get("formId") != null) {
                condition.append(" form_id = #{formId} ");
            } else if (condition.length() > 0 && param.get("formId") != null) {
                condition.append(" and form_id = #{formId} ");
            }
            if (condition.length() == 0 && param.get("value") != null) {
                condition.append(" value = #{value} ");
            } else if (condition.length() > 0 && param.get("value") != null) {
                condition.append(" and value = #{value} ");
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
            if (condition.length() == 0 && param.get("formId") != null) {
                condition.append(" form_id = #{formId} ");
            } else if (condition.length() > 0 && param.get("formId") != null) {
                condition.append(" and form_id = #{formId} ");
            }
            if (condition.length() == 0 && param.get("value") != null) {
                condition.append(" value = #{value} ");
            } else if (condition.length() > 0 && param.get("value") != null) {
                condition.append(" and value = #{value} ");
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