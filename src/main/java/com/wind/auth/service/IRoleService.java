package com.wind.auth.service;

import com.wind.auth.model.Role;

/**
 * IRoleService role 服务接口
 *
 * @author qianchun 17/9/18
 **/
public interface IRoleService {
    boolean save(Role app);
    Role findById(long id);
}

