package com.wind.auth.mapper;

import com.wind.auth.model.Menu;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface MenuMapper {
    @Delete({
        "delete from menu",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into menu (id, name, ",
        "status, app_id, url, ",
        "create_time, update_time, ",
        "parent_id)",
        "values (#{id,jdbcType=BIGINT}, #{name,jdbcType=VARCHAR}, ",
        "#{status,jdbcType=TINYINT}, #{appId,jdbcType=BIGINT}, #{url,jdbcType=VARCHAR}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updateTime,jdbcType=TIMESTAMP}, ",
        "#{parentId,jdbcType=BIGINT})"
    })
    int insert(Menu record);

    @InsertProvider(type=MenuSqlProvider.class, method="insertSelective")
    int insertSelective(Menu record);

    @Select({
        "select",
        "id, name, status, app_id, url, create_time, update_time, parent_id",
        "from menu",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
        @Result(column="app_id", property="appId", jdbcType=JdbcType.BIGINT),
        @Result(column="url", property="url", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="parent_id", property="parentId", jdbcType=JdbcType.BIGINT)
    })
    Menu selectByPrimaryKey(Long id);

    @UpdateProvider(type=MenuSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Menu record);

    @Update({
        "update menu",
        "set name = #{name,jdbcType=VARCHAR},",
          "status = #{status,jdbcType=TINYINT},",
          "app_id = #{appId,jdbcType=BIGINT},",
          "url = #{url,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP},",
          "parent_id = #{parentId,jdbcType=BIGINT}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(Menu record);
}