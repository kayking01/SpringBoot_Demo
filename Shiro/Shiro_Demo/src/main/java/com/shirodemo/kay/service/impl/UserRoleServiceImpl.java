package com.shirodemo.kay.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shirodemo.kay.entity.UserRole;
import com.shirodemo.kay.service.UserRoleService;
import com.shirodemo.kay.mapper.UserRoleMapper;
import org.springframework.stereotype.Service;

/**
* @author kay
* @description 针对表【sys_user_role(用户与角色对应关系)】的数据库操作Service实现
* @createDate 2022-05-25 20:11:29
*/
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole>
    implements UserRoleService{

}




