package com.shirodemo.kay.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shirodemo.kay.entity.TestUser;
import com.shirodemo.kay.mapper.TestUserMapper;
import com.shirodemo.kay.service.TestUserService;
import org.springframework.stereotype.Service;

/**
* @author kay
* @description 针对表【test_user】的数据库操作Service实现
* @createDate 2022-05-27 15:35:58
*/
@Service
public class TestUserServiceImpl extends ServiceImpl<TestUserMapper, TestUser>
    implements TestUserService{

    @Override
    public TestUser findByUsername(String username) {
        return this.baseMapper.findByUsername(username);
    }
}




