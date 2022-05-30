package com.shirodemo.kay.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shirodemo.kay.entity.Role;
import com.shirodemo.kay.service.RoleService;
import com.shirodemo.kay.mapper.RoleMapper;
import org.springframework.stereotype.Service;

/**
* @author kay
* @description 针对表【sys_role(角色)】的数据库操作Service实现
* @createDate 2022-05-25 20:11:06
*/
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role>
    implements RoleService{

}




