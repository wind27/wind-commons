package com.wind.form.dao;

import com.wind.form.model.Form;
import com.wind.common.Page;
import com.wind.annotation.DAO;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.jdbc.SQL;
import java.util.Map;

/**
 * FormDao
 * 表单信息表
 */
@DAO(catalog = "form")
public interface FormDao {

    /**
     * 表名
     */
    String TABLE_NAME = "form";

    /**
     * 列名
     */
    String COLLOMN = "id, name, css_class, tr_css_class, td_class, create_time, update_time";


    /**
     * 查询语句
     */
    String SELECT_SQL = "SELECT " + COLLOMN + " FROM form";

    /**
     * 新增
     */
    @InsertProvider(type=FormProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int save(Form form );


    /**
     * 更新
     */
    @UpdateProvider(type=FormProvider.class, method="updateByPrimaryKeySelective")
    int update(Form form);

    /**
     * 删除
     */
    @Delete("DELETE FROM form WHERE id= #{primary}")
    int delete(Long primary);

    /**
    * 根据主键查询
    */
    @Select(SELECT_SQL+ " WHERE id = #{primary} limit 0, 1")
    Form getByPrimary(Long primary );

    /**
     * 统计
     */
    @Select("SELECT COUNT(1) FROM form")
    int count(Map<String, Object> param);

    public class FormProvider {
        public String insertSelective(Form form) {
            SQL sql = new SQL();
            sql.INSERT_INTO("form");

            if (form.getId() != null) {
                sql.VALUES("id", "#{id}");
            }
            if (form.getName() != null) {
                sql.VALUES("name", "#{name}");
            }
            if (form.getCssClass() != null) {
                sql.VALUES("css_class", "#{cssClass}");
            }
            if (form.getTrCssClass() != null) {
                sql.VALUES("tr_css_class", "#{trCssClass}");
            }
            if (form.getTdClass() != null) {
                sql.VALUES("td_class", "#{tdClass}");
            }
            if (form.getCreateTime() != null) {
                sql.VALUES("create_time", "#{createTime}");
            }
            if (form.getUpdateTime() != null) {
                sql.VALUES("update_time", "#{updateTime}");
            }

            return sql.toString();
        }

        public String updateByPrimaryKeySelective(Form form) {
            SQL sql = new SQL();
            sql.UPDATE("form");
            if (form.getId() != null) {
                sql.SET("id = #{id}");
            }
            if (form.getName() != null) {
                sql.SET("name = #{name}");
            }
            if (form.getCssClass() != null) {
                sql.SET("css_class = #{cssClass}");
            }
            if (form.getTrCssClass() != null) {
                sql.SET("tr_css_class = #{trCssClass}");
            }
            if (form.getTdClass() != null) {
                sql.SET("td_class = #{tdClass}");
            }
            if (form.getCreateTime() != null) {
                sql.SET("create_time = #{createTime}");
            }
            if (form.getUpdateTime() != null) {
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
            if (condition.length() == 0 && param.get("cssClass") != null) {
                condition.append(" css_class = #{cssClass} ");
            } else if (condition.length() > 0 && param.get("cssClass") != null) {
                condition.append(" and css_class = #{cssClass} ");
            }
            if (condition.length() == 0 && param.get("trCssClass") != null) {
                condition.append(" tr_css_class = #{trCssClass} ");
            } else if (condition.length() > 0 && param.get("trCssClass") != null) {
                condition.append(" and tr_css_class = #{trCssClass} ");
            }
            if (condition.length() == 0 && param.get("tdClass") != null) {
                condition.append(" td_class = #{tdClass} ");
            } else if (condition.length() > 0 && param.get("tdClass") != null) {
                condition.append(" and td_class = #{tdClass} ");
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
            if (condition.length() == 0 && param.get("cssClass") != null) {
                condition.append(" css_class = #{cssClass} ");
            } else if (condition.length() > 0 && param.get("cssClass") != null) {
                condition.append(" and css_class = #{cssClass} ");
            }
            if (condition.length() == 0 && param.get("trCssClass") != null) {
                condition.append(" tr_css_class = #{trCssClass} ");
            } else if (condition.length() > 0 && param.get("trCssClass") != null) {
                condition.append(" and tr_css_class = #{trCssClass} ");
            }
            if (condition.length() == 0 && param.get("tdClass") != null) {
                condition.append(" td_class = #{tdClass} ");
            } else if (condition.length() > 0 && param.get("tdClass") != null) {
                condition.append(" and td_class = #{tdClass} ");
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