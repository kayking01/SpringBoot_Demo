package com.shirodemo.kay.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shirodemo.kay.entity.UserLoginLog;
import com.shirodemo.kay.service.UserLoginLogService;
import com.shirodemo.kay.mapper.UserLoginLogMapper;
import org.springframework.stereotype.Service;

/**
* @author kay
* @description 针对表【sys_user_login_log(用户登录表)】的数据库操作Service实现
* @createDate 2022-05-25 20:11:26
*/
@Service
public class UserLoginLogServiceImpl extends ServiceImpl<UserLoginLogMapper, UserLoginLog>
    implements UserLoginLogService{

}




