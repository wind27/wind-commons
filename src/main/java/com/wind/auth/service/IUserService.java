package com.wind.auth.service;



import com.wind.auth.model.LinkUserRole;
import com.wind.auth.model.User;

import java.util.List;

/**
 * IUserService user  服务接口
 *
 * @author qianchun 17/9/18
 **/
public interface IUserService {
    User save(User user);
    User findById(long id);
    LinkUserRole save(LinkUserRole linkUserRole);
    boolean batchSave(List<LinkUserRole> linkUserRoleList);
}

