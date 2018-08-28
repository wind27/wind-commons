package com.wind.blog.mapper;

import com.wind.blog.model.Blog;
import org.apache.ibatis.jdbc.SQL;

public class BlogSqlProvider {

    public String insertSelective(Blog record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("blog");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=BIGINT}");
        }
        
        if (record.getTags() != null) {
            sql.VALUES("tags", "#{tags,jdbcType=VARCHAR}");
        }
        
        if (record.getSource() != null) {
            sql.VALUES("source", "#{source,jdbcType=INTEGER}");
        }
        
        if (record.getTitle() != null) {
            sql.VALUES("title", "#{title,jdbcType=VARCHAR}");
        }
        
        if (record.getSummary() != null) {
            sql.VALUES("summary", "#{summary,jdbcType=VARCHAR}");
        }
        
        if (record.getUid() != null) {
            sql.VALUES("uid", "#{uid,jdbcType=BIGINT}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.VALUES("update_time", "#{updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getPublishTime() != null) {
            sql.VALUES("publish_time", "#{publishTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getContent() != null) {
            sql.VALUES("content", "#{content,jdbcType=LONGVARCHAR}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Blog record) {
        SQL sql = new SQL();
        sql.UPDATE("blog");
        
        if (record.getTags() != null) {
            sql.SET("tags = #{tags,jdbcType=VARCHAR}");
        }
        
        if (record.getSource() != null) {
            sql.SET("source = #{source,jdbcType=INTEGER}");
        }
        
        if (record.getTitle() != null) {
            sql.SET("title = #{title,jdbcType=VARCHAR}");
        }
        
        if (record.getSummary() != null) {
            sql.SET("summary = #{summary,jdbcType=VARCHAR}");
        }
        
        if (record.getUid() != null) {
            sql.SET("uid = #{uid,jdbcType=BIGINT}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.SET("update_time = #{updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getPublishTime() != null) {
            sql.SET("publish_time = #{publishTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getContent() != null) {
            sql.SET("content = #{content,jdbcType=LONGVARCHAR}");
        }
        
        sql.WHERE("id = #{id,jdbcType=BIGINT}");
        
        return sql.toString();
    }
}