package com.wind.blog.dao;

import com.wind.blog.model.Blog;
import com.wind.common.Page;
import com.wind.annotation.DAO;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.jdbc.SQL;
import java.util.Map;

/**
 *
 * BlogDao
 * blog信息表
 */
@DAO(catalog = "blog")
public interface BlogDao {

    /**
     * 表名
     */
    String TABLE_NAME = "blog";

    /**
     * 列名
     */
    String COLLOMN = "id, tags, source, title, content, summary, uid, status, create_time, update_time, publish_time";


    /**
     * 查询语句
     */
    String SELECT_SQL = "SELECT " + COLLOMN + " FROM blog";

    /**
     * 新增
     */
    @InsertProvider(type=BlogProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int save(Blog blog );


    /**
     * 更新
     */
    @UpdateProvider(type=BlogProvider.class, method="updateByPrimaryKeySelective")
    int update(Blog blog);

    /**
     * 删除
     */
    @Delete("DELETE FROM blog WHERE id= #{primary}")
    int delete(Long primary);

    /**
    * 根据主键查询
    */
    @Select(SELECT_SQL+ " WHERE id = #{primary} limit 0, 1")
    Blog getByPrimary(Long primary );

    /**
     * 统计
     */
    @Select("SELECT COUNT(1) FROM blog")
    int count(Map<String, Object> param);

    public class BlogProvider {
        public String insertSelective(Blog blog) {
            SQL sql = new SQL();
            sql.INSERT_INTO("blog");

            if (blog.getId() != null) {
                sql.VALUES("id", "#{id}");
            }
            if (blog.getTags() != null) {
                sql.VALUES("tags", "#{tags}");
            }
            if (blog.getSource() != null) {
                sql.VALUES("source", "#{source}");
            }
            if (blog.getTitle() != null) {
                sql.VALUES("title", "#{title}");
            }
            if (blog.getContent() != null) {
                sql.VALUES("content", "#{content}");
            }
            if (blog.getSummary() != null) {
                sql.VALUES("summary", "#{summary}");
            }
            if (blog.getUid() != null) {
                sql.VALUES("uid", "#{uid}");
            }
            if (blog.getStatus() != null) {
                sql.VALUES("status", "#{status}");
            }
            if (blog.getCreateTime() != null) {
                sql.VALUES("create_time", "#{createTime}");
            }
            if (blog.getUpdateTime() != null) {
                sql.VALUES("update_time", "#{updateTime}");
            }
            if (blog.getPublishTime() != null) {
                sql.VALUES("publish_time", "#{publishTime}");
            }

            return sql.toString();
        }

        public String updateByPrimaryKeySelective(Blog blog) {
            SQL sql = new SQL();
            sql.UPDATE("blog");
            if (blog.getId() != null) {
                sql.SET("id = #{id}");
            }
            if (blog.getTags() != null) {
                sql.SET("tags = #{tags}");
            }
            if (blog.getSource() != null) {
                sql.SET("source = #{source}");
            }
            if (blog.getTitle() != null) {
                sql.SET("title = #{title}");
            }
            if (blog.getContent() != null) {
                sql.SET("content = #{content}");
            }
            if (blog.getSummary() != null) {
                sql.SET("summary = #{summary}");
            }
            if (blog.getUid() != null) {
                sql.SET("uid = #{uid}");
            }
            if (blog.getStatus() != null) {
                sql.SET("status = #{status}");
            }
            if (blog.getCreateTime() != null) {
                sql.SET("create_time = #{createTime}");
            }
            if (blog.getUpdateTime() != null) {
                sql.SET("update_time = #{updateTime}");
            }
            if (blog.getPublishTime() != null) {
                sql.SET("publish_time = #{publishTime}");
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
            if (condition.length() == 0 && param.get("tags") != null) {
                condition.append(" tags = #{tags} ");
            } else if (condition.length() > 0 && param.get("tags") != null) {
                condition.append(" and tags = #{tags} ");
            }
            if (condition.length() == 0 && param.get("source") != null) {
                condition.append(" source = #{source} ");
            } else if (condition.length() > 0 && param.get("source") != null) {
                condition.append(" and source = #{source} ");
            }
            if (condition.length() == 0 && param.get("title") != null) {
                condition.append(" title = #{title} ");
            } else if (condition.length() > 0 && param.get("title") != null) {
                condition.append(" and title = #{title} ");
            }
            if (condition.length() == 0 && param.get("content") != null) {
                condition.append(" content = #{content} ");
            } else if (condition.length() > 0 && param.get("content") != null) {
                condition.append(" and content = #{content} ");
            }
            if (condition.length() == 0 && param.get("summary") != null) {
                condition.append(" summary = #{summary} ");
            } else if (condition.length() > 0 && param.get("summary") != null) {
                condition.append(" and summary = #{summary} ");
            }
            if (condition.length() == 0 && param.get("uid") != null) {
                condition.append(" uid = #{uid} ");
            } else if (condition.length() > 0 && param.get("uid") != null) {
                condition.append(" and uid = #{uid} ");
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
            if (condition.length() == 0 && param.get("publishTime") != null) {
                condition.append(" publish_time = #{publishTime} ");
            } else if (condition.length() > 0 && param.get("publishTime") != null) {
                condition.append(" and publish_time = #{publishTime} ");
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
            if (condition.length() == 0 && param.get("tags") != null) {
                condition.append(" tags = #{tags} ");
            } else if (condition.length() > 0 && param.get("tags") != null) {
                condition.append(" and tags = #{tags} ");
            }
            if (condition.length() == 0 && param.get("source") != null) {
                condition.append(" source = #{source} ");
            } else if (condition.length() > 0 && param.get("source") != null) {
                condition.append(" and source = #{source} ");
            }
            if (condition.length() == 0 && param.get("title") != null) {
                condition.append(" title = #{title} ");
            } else if (condition.length() > 0 && param.get("title") != null) {
                condition.append(" and title = #{title} ");
            }
            if (condition.length() == 0 && param.get("content") != null) {
                condition.append(" content = #{content} ");
            } else if (condition.length() > 0 && param.get("content") != null) {
                condition.append(" and content = #{content} ");
            }
            if (condition.length() == 0 && param.get("summary") != null) {
                condition.append(" summary = #{summary} ");
            } else if (condition.length() > 0 && param.get("summary") != null) {
                condition.append(" and summary = #{summary} ");
            }
            if (condition.length() == 0 && param.get("uid") != null) {
                condition.append(" uid = #{uid} ");
            } else if (condition.length() > 0 && param.get("uid") != null) {
                condition.append(" and uid = #{uid} ");
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
            if (condition.length() == 0 && param.get("publishTime") != null) {
                condition.append(" publish_time = #{publishTime} ");
            } else if (condition.length() > 0 && param.get("publishTime") != null) {
                condition.append(" and publish_time = #{publishTime} ");
            }
            sql.FROM(TABLE_NAME);
            if (condition.length() > 0) {
                sql.WHERE(condition.toString());
            }
            return sql.toString();
        }
    }
}