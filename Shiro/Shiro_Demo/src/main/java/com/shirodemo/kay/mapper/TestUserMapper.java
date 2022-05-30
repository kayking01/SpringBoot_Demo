package com.shirodemo.kay.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shirodemo.kay.entity.TestUser;

/**
* @author kay
* @description 针对表【test_user】的数据库操作Mapper
* @createDate 2022-05-27 15:35:58
* @Entity com.shirodemo.kay.entity.TestUser
*/
public interface TestUserMapper extends BaseMapper<TestUser> {

    TestUser findByUsername(String username);
}




