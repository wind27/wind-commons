package com.wind.auth.dao;

import com.wind.auth.model.LinkRolePermission;

public interface LinkRolePermissionMapper {
    int deleteByPrimaryKey(Long id);

    int insert(LinkRolePermission record);

    int insertSelective(LinkRolePermission record);

    LinkRolePermission selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(LinkRolePermission record);

    int updateByPrimaryKey(LinkRolePermission record);
}