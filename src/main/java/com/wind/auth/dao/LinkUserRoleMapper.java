package com.wind.auth.dao;

import com.wind.auth.model.LinkUserRole;

public interface LinkUserRoleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(LinkUserRole record);

    int insertSelective(LinkUserRole record);

    LinkUserRole selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(LinkUserRole record);

    int updateByPrimaryKey(LinkUserRole record);
}