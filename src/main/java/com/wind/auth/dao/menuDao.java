package com.wind.auth.dao;

import com.wind.auth.model.Menu;
import com.wind.auth.dao.provider.MenuProvider;

import org.apache.ibatis.annotations.*;

/**
 *
 * MenuDao
 * 
 */
@Mapper
interface MenuDao {

    /**
     * 表名
     */
    String TABLE_NAME = "menu";

    /**
     * 列名
     */
    String COLLOMN = "id, name, status, app_id, url, create_time, update_time, parent_id";


    /**
     * 查询语句
     */
    String SELECT_SQL = "SELECT " + COLLOMN + " FROM menu";

    /**
     * 新增
     */
    @InsertProvider(type=MenuProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int save(Menu menu );


    /**
     * 更新
     */
    @UpdateProvider(type=MenuProvider.class, method="updateByPrimaryKeySelective")
    int update(Menu menu);

    /**
     * 删除
     */
    @Delete("DELETE FROM menu WHERE id= :1")
    int delete(Long primary);

    /**
    * 根据主键查询
    */
    @Select(SELECT_SQL+ " WHERE id = :1")
    Menu getByPrimary(Long primary );

    /**
     * 统计
     */
    @Select("SELECT COUNT(1) FROM menu")
    long count();
}