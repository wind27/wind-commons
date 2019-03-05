package com.wind.form.dao;

import com.wind.form.model.Field;
import com.wind.common.Page;
import com.wind.annotation.DAO;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.jdbc.SQL;
import java.util.Map;

/**
 * FieldDao
 * 表单属性信息表
 */
@DAO(catalog = "form")
public interface FieldDao {

    /**
     * 表名
     */
    String TABLE_NAME = "field";

    /**
     * 列名
     */
    String COLLOMN = "id, form_id, name, is_must, type, css_class, is_show, default_val, create_time, update_time";


    /**
     * 查询语句
     */
    String SELECT_SQL = "SELECT " + COLLOMN + " FROM field";

    /**
     * 新增
     */
    @InsertProvider(type=FieldProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int save(Field field );


    /**
     * 更新
     */
    @UpdateProvider(type=FieldProvider.class, method="updateByPrimaryKeySelective")
    int update(Field field);

    /**
     * 删除
     */
    @Delete("DELETE FROM field WHERE id= #{primary}")
    int delete(Long primary);

    /**
    * 根据主键查询
    */
    @Select(SELECT_SQL+ " WHERE id = #{primary} limit 0, 1")
    Field getByPrimary(Long primary );

    /**
     * 统计
     */
    @Select("SELECT COUNT(1) FROM field")
    int count(Map<String, Object> param);

    public class FieldProvider {
        public String insertSelective(Field field) {
            SQL sql = new SQL();
            sql.INSERT_INTO("field");

            if (field.getId() != null) {
                sql.VALUES("id", "#{id}");
            }
            if (field.getFormId() != null) {
                sql.VALUES("form_id", "#{formId}");
            }
            if (field.getName() != null) {
                sql.VALUES("name", "#{name}");
            }
            if (field.getIsMust() != null) {
                sql.VALUES("is_must", "#{isMust}");
            }
            if (field.getType() != null) {
                sql.VALUES("type", "#{type}");
            }
            if (field.getCssClass() != null) {
                sql.VALUES("css_class", "#{cssClass}");
            }
            if (field.getIsShow() != null) {
                sql.VALUES("is_show", "#{isShow}");
            }
            if (field.getDefaultVal() != null) {
                sql.VALUES("default_val", "#{defaultVal}");
            }
            if (field.getCreateTime() != null) {
                sql.VALUES("create_time", "#{createTime}");
            }
            if (field.getUpdateTime() != null) {
                sql.VALUES("update_time", "#{updateTime}");
            }

            return sql.toString();
        }

        public String updateByPrimaryKeySelective(Field field) {
            SQL sql = new SQL();
            sql.UPDATE("field");
            if (field.getId() != null) {
                sql.SET("id = #{id}");
            }
            if (field.getFormId() != null) {
                sql.SET("form_id = #{formId}");
            }
            if (field.getName() != null) {
                sql.SET("name = #{name}");
            }
            if (field.getIsMust() != null) {
                sql.SET("is_must = #{isMust}");
            }
            if (field.getType() != null) {
                sql.SET("type = #{type}");
            }
            if (field.getCssClass() != null) {
                sql.SET("css_class = #{cssClass}");
            }
            if (field.getIsShow() != null) {
                sql.SET("is_show = #{isShow}");
            }
            if (field.getDefaultVal() != null) {
                sql.SET("default_val = #{defaultVal}");
            }
            if (field.getCreateTime() != null) {
                sql.SET("create_time = #{createTime}");
            }
            if (field.getUpdateTime() != null) {
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
            if (condition.length() == 0 && param.get("name") != null) {
                condition.append(" name = #{name} ");
            } else if (condition.length() > 0 && param.get("name") != null) {
                condition.append(" and name = #{name} ");
            }
            if (condition.length() == 0 && param.get("isMust") != null) {
                condition.append(" is_must = #{isMust} ");
            } else if (condition.length() > 0 && param.get("isMust") != null) {
                condition.append(" and is_must = #{isMust} ");
            }
            if (condition.length() == 0 && param.get("type") != null) {
                condition.append(" type = #{type} ");
            } else if (condition.length() > 0 && param.get("type") != null) {
                condition.append(" and type = #{type} ");
            }
            if (condition.length() == 0 && param.get("cssClass") != null) {
                condition.append(" css_class = #{cssClass} ");
            } else if (condition.length() > 0 && param.get("cssClass") != null) {
                condition.append(" and css_class = #{cssClass} ");
            }
            if (condition.length() == 0 && param.get("isShow") != null) {
                condition.append(" is_show = #{isShow} ");
            } else if (condition.length() > 0 && param.get("isShow") != null) {
                condition.append(" and is_show = #{isShow} ");
            }
            if (condition.length() == 0 && param.get("defaultVal") != null) {
                condition.append(" default_val = #{defaultVal} ");
            } else if (condition.length() > 0 && param.get("defaultVal") != null) {
                condition.append(" and default_val = #{defaultVal} ");
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
            if (condition.length() == 0 && param.get("name") != null) {
                condition.append(" name = #{name} ");
            } else if (condition.length() > 0 && param.get("name") != null) {
                condition.append(" and name = #{name} ");
            }
            if (condition.length() == 0 && param.get("isMust") != null) {
                condition.append(" is_must = #{isMust} ");
            } else if (condition.length() > 0 && param.get("isMust") != null) {
                condition.append(" and is_must = #{isMust} ");
            }
            if (condition.length() == 0 && param.get("type") != null) {
                condition.append(" type = #{type} ");
            } else if (condition.length() > 0 && param.get("type") != null) {
                condition.append(" and type = #{type} ");
            }
            if (condition.length() == 0 && param.get("cssClass") != null) {
                condition.append(" css_class = #{cssClass} ");
            } else if (condition.length() > 0 && param.get("cssClass") != null) {
                condition.append(" and css_class = #{cssClass} ");
            }
            if (condition.length() == 0 && param.get("isShow") != null) {
                condition.append(" is_show = #{isShow} ");
            } else if (condition.length() > 0 && param.get("isShow") != null) {
                condition.append(" and is_show = #{isShow} ");
            }
            if (condition.length() == 0 && param.get("defaultVal") != null) {
                condition.append(" default_val = #{defaultVal} ");
            } else if (condition.length() > 0 && param.get("defaultVal") != null) {
                condition.append(" and default_val = #{defaultVal} ");
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