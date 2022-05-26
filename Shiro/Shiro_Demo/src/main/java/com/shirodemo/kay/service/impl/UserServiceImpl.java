package com.shirodemo.kay.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shirodemo.kay.entity.User;
import com.shirodemo.kay.service.UserService;
import com.shirodemo.kay.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
* @author kay
* @description 针对表【sys_user(系统用户)】的数据库操作Service实现
* @createDate 2022-05-25 20:11:23
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

}




