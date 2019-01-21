package com.wind.blog.dao;

import com.wind.blog.model.Blog;

import org.apache.ibatis.annotations.*;

/**
 * ${table.daoName2} blog信息表
 */
@Mapper
interface BlogDao {

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
    String SELECT_SQL = "SELECT id, tags, source, title, content, summary, uid, status, create_time, update_time, publish_time FROM blog";

    /**
     * 新增 sql
     */
    String INSERT_SQL =
            "<script> " +
            "INSERT INTO blog ("
            + "id"
            + "<if test=\"tags!=null\"> ,tags</if>"
            + "<if test=\"source!=null\"> ,source</if>"
            + "<if test=\"title!=null\"> ,title</if>"
            + "<if test=\"content!=null\"> ,content</if>"
            + "<if test=\"summary!=null\"> ,summary</if>"
            + "<if test=\"uid!=null\"> ,uid</if>"
            + "<if test=\"status!=null\"> ,status</if>"
            + "<if test=\"createTime!=null\"> ,create_time</if>"
            + "<if test=\"updateTime!=null\"> ,update_time</if>"
            + "<if test=\"publishTime!=null\"> ,publish_time</if>"
            + ") VALUES("
            + "#{id}"
            + "<if test=\"tags!=null\"> ,#{tags}</if>"
            + "<if test=\"source!=null\"> ,#{source}</if>"
            + "<if test=\"title!=null\"> ,#{title}</if>"
            + "<if test=\"content!=null\"> ,#{content}</if>"
            + "<if test=\"summary!=null\"> ,#{summary}</if>"
            + "<if test=\"uid!=null\"> ,#{uid}</if>"
            + "<if test=\"status!=null\"> ,#{status}</if>"
            + "<if test=\"createTime!=null\"> ,#{createTime}</if>"
            + "<if test=\"updateTime!=null\"> ,#{updateTime}</if>"
            + "<if test=\"publishTime!=null\"> ,#{publishTime}</if>"
            + ") </script> ";

    /**
     * 更新 sql
     */
    String UPDATE_COLS = "#if(:1.tags!=null){,tags=:1.tags}" + "#if(:1.source!=null){,source=:1.source}"
            + "#if(:1.title!=null){,title=:1.title}" + "#if(:1.content!=null){,content=:1.content}"
            + "#if(:1.summary!=null){,summary=:1.summary}" + "#if(:1.uid!=null){,uid=:1.uid}"
            + "#if(:1.status!=null){,status=:1.status}" + "#if(:1.createTime!=null){,create_time=:1.createTime}"
            + "#if(:1.updateTime!=null){,update_time=:1.updateTime}"
            + "#if(:1.publishTime!=null){,publish_time=:1.publishTime}" + "";

    /**
     * 新增
     */
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert(INSERT_SQL)
    int insert(Blog blog);

    /**
     * 更新
     */
    @Update("UPDATE blog SET id=:1.id " + UPDATE_COLS + " WHERE id=:1.id ")
    int update(Blog blog);

    /**
     * 删除
     */
    @Delete("DELETE FROM blog WHERE id= #{primary}")
    void delete(Long primary);

    /**
     * 根据主键查询
     */
    @Select(SELECT_SQL + " WHERE id = #{primary}")
    Blog getByPrimary(Long primary);

    /**
     * 统计
     */
    @Select("SELECT COUNT(1) FROM blog")
    long count();
}