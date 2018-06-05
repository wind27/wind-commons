package com.wind.auth.service;



import com.wind.auth.model.App;

/**
 * IAppService app 服务接口
 *
 * @author qianchun 17/9/18
 **/
public interface IAppService {
    App save(App app);
    App findById(long id);
}

