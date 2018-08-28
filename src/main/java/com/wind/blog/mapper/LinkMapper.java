package com.wind.blog.mapper;

import com.wind.blog.model.Link;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface LinkMapper {
    @Delete({
        "delete from link",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into link (id, source, ",
        "url, is_parse, blog_id)",
        "values (#{id,jdbcType=BIGINT}, #{source,jdbcType=INTEGER}, ",
        "#{url,jdbcType=VARCHAR}, #{isParse,jdbcType=INTEGER}, #{blogId,jdbcType=BIGINT})"
    })
    int insert(Link record);

    @InsertProvider(type=LinkSqlProvider.class, method="insertSelective")
    int insertSelective(Link record);

    @Select({
        "select",
        "id, source, url, is_parse, blog_id",
        "from link",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="source", property="source", jdbcType=JdbcType.INTEGER),
        @Result(column="url", property="url", jdbcType=JdbcType.VARCHAR),
        @Result(column="is_parse", property="isParse", jdbcType=JdbcType.INTEGER),
        @Result(column="blog_id", property="blogId", jdbcType=JdbcType.BIGINT)
    })
    Link selectByPrimaryKey(Long id);

    @UpdateProvider(type=LinkSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Link record);

    @Update({
        "update link",
        "set source = #{source,jdbcType=INTEGER},",
          "url = #{url,jdbcType=VARCHAR},",
          "is_parse = #{isParse,jdbcType=INTEGER},",
          "blog_id = #{blogId,jdbcType=BIGINT}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(Link record);
}