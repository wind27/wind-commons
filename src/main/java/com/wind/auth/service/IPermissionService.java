package com.wind.auth.service;



import com.wind.auth.model.Permission;

/**
 * IPermissionService permission 服务接口
 *
 * @author qianchun 17/9/18
 **/
public interface IPermissionService {
    boolean save(Permission permission);
    Permission findById(long id);
}

