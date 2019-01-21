package com.wind.blog.dao;

import com.wind.blog.model.Blog;

import java.text.MessageFormat;
import java.util.List;
import java.util.Map;

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

    String COLLOMN = "id, tags, source, title, content, summary, uid, status, create_time, update_time, publish_time";

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
     * 批量新增 sql
     */
    String INSERT_SQL_BAT =
            "<script> " +
                    "INSERT INTO blog (" + COLLOMN + ") VALUES "
                    + "<foreach collection=\"list\" item=\"item\" index=\"index\" open=\"(\" close=\")\" separator=\",\">"
                    + "#{item.id},#{item.tags}, #{item.source}, #{item.title}, #{item.content}, #{item.summary}, "
                    + "#{item.uid}, #{item.status}, #{item.create_time}, #{item.update_time}, #{item.publish_time}"
                    + "</foreach>"
                    + "</script> ";

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
     * 批量新增
     */
    @InsertProvider(type = Provider.class, method = "batchInsert")
    void batchInsert(@Param("list") List<Blog> list);

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
     * 批量删除
     */
    @Delete("DELETE FROM blog WHERE id in (#{primary})")
    void deleteByPrimaryList(List<Long> primaryList);

    /**
     * 根据主键查询
     */
    @Select(SELECT_SQL + " WHERE id = #{primary}")
    Blog getByPrimary(Long primary);

    /**
     * 根据主键ids查询 list
     */
    @Select(SELECT_SQL + " WHERE id IN (#{primary})")
    List<Blog> getListByPrimaryList(List<Long> primaryList);

    /**
     * 根据主键ids查询 map
     */
    @Select(SELECT_SQL + " WHERE id IN (#{primary})")
    @MapKey("id")
    Map<Long, Blog> getMapByPrimaryList(List<Long> primaryList);

    @Select(SELECT_SQL + " limit 0, 30")
    List<Blog> list();

    /**
     * 统计
     */
    @Select("SELECT COUNT(1) FROM blog")
    long count();




    class Provider {
        /* 批量插入 */
        public String batchInsert(Map<String,Object> map) {
            List<Blog> blogList = (List<Blog>) map.get("list");
            StringBuilder sb = new StringBuilder();
            sb.append("INSERT INTO blog ("+COLLOMN+") VALUES ");
            MessageFormat mf = new MessageFormat(
                            "(#'{'list[{0}].id'}'," +
                            "#'{'list[{0}].tags'}', " +
                            "#'{'list[{0}].source'}', " +
                            "#'{'list[{0}].title'}', " +
                            "#'{'list[{0}].content'}', " +
                            "#'{'list[{0}].summary'}', " +
                            "#'{'list[{0}].uid'}', " +
                            "#'{'list[{0}].status'}', " +
                            "#'{'list[{0}].createTime'}', " +
                            "#'{'list[{0}].updateTime'}', " +
                            "#'{'list[{0}].publishTime'}')"
            );

            for (int i = 0; i < blogList.size(); i++) {
                sb.append(mf.format(new Object[] {i}));
                if (i < blogList.size() - 1)
                    sb.append(",");
            }
            return sb.toString();
        }

        /* 批量删除 */
//        public String batchDelete(Map map) {
//            List<Student> students = (List<Student>) map.get("list");
//            StringBuilder sb = new StringBuilder();
//            sb.append("DELETE FROM student WHERE id IN (");
//            for (int i = 0; i < students.size(); i++) {
//                sb.append("'").append(students.get(i).getId()).append("'");
//                if (i < students.size() - 1)
//                    sb.append(",");
//            }
//            sb.append(")");
//            return sb.toString();
//        }
    }
}