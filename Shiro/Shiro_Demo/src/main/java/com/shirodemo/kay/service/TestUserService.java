package com.shirodemo.kay.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.shirodemo.kay.entity.TestUser;

/**
* @author kay
* @description 针对表【test_user】的数据库操作Service
* @createDate 2022-05-27 15:35:58
*/
public interface TestUserService extends IService<TestUser> {
    TestUser findByUsername(String username);
}
