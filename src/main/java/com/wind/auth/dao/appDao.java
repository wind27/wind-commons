package com.wind.auth.dao;

import com.wind.auth.model.App;
import com.wind.auth.dao.provider.AppProvider;

import org.apache.ibatis.annotations.*;

/**
 *
 * AppDao
 * 应用APP
 */
@Mapper
interface AppDao {

    /**
     * 表名
     */
    String TABLE_NAME = "app";

    /**
     * 列名
     */
    String COLLOMN = "id, name, home_page_url, status, create_time, update_time";


    /**
     * 查询语句
     */
    String SELECT_SQL = "SELECT " + COLLOMN + " FROM app";

    /**
     * 新增
     */
    @InsertProvider(type=AppProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int save(App app );


    /**
     * 更新
     */
    @UpdateProvider(type=AppProvider.class, method="updateByPrimaryKeySelective")
    int update(App app);

    /**
     * 删除
     */
    @Delete("DELETE FROM app WHERE id= :1")
    int delete(Long primary);

    /**
    * 根据主键查询
    */
    @Select(SELECT_SQL+ " WHERE id = :1")
    App getByPrimary(Long primary );

    /**
     * 统计
     */
    @Select("SELECT COUNT(1) FROM app")
    long count();
}