package com.wind.user.service;


import com.wind.user.model.User;
import com.wind.user.model.UserRole;

import java.util.List;

/**
 * IUserService
 *
 * @author qianchun 17/9/18
 **/
public interface IUserService {
    public boolean save(User user);
    public User findById(long id);
    public boolean save(UserRole userRole);
    public boolean batchSave(List<UserRole> userRoleList);
}

