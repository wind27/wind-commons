package com.wind.blog.mapper;

import com.wind.blog.model.Link;
import org.apache.ibatis.jdbc.SQL;

public class LinkSqlProvider {

    public String insertSelective(Link record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("link");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=BIGINT}");
        }
        
        if (record.getFrom() != null) {
            sql.VALUES("from", "#{from,jdbcType=TINYINT}");
        }
        
        if (record.getUrl() != null) {
            sql.VALUES("url", "#{url,jdbcType=VARCHAR}");
        }
        
        if (record.getIsParse() != null) {
            sql.VALUES("is_parse", "#{isParse,jdbcType=TINYINT}");
        }
        
        if (record.getBlogId() != null) {
            sql.VALUES("blog_id", "#{blogId,jdbcType=BIGINT}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Link record) {
        SQL sql = new SQL();
        sql.UPDATE("link");
        
        if (record.getFrom() != null) {
            sql.SET("from = #{from,jdbcType=TINYINT}");
        }
        
        if (record.getUrl() != null) {
            sql.SET("url = #{url,jdbcType=VARCHAR}");
        }
        
        if (record.getIsParse() != null) {
            sql.SET("is_parse = #{isParse,jdbcType=TINYINT}");
        }
        
        if (record.getBlogId() != null) {
            sql.SET("blog_id = #{blogId,jdbcType=BIGINT}");
        }
        
        sql.WHERE("id = #{id,jdbcType=BIGINT}");
        
        return sql.toString();
    }
}