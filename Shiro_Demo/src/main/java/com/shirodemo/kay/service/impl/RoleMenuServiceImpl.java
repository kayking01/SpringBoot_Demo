package com.shirodemo.kay.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shirodemo.kay.entity.RoleMenu;
import com.shirodemo.kay.service.RoleMenuService;
import com.shirodemo.kay.mapper.RoleMenuMapper;
import org.springframework.stereotype.Service;

/**
* @author kay
* @description 针对表【sys_role_menu(角色与菜单对应关系)】的数据库操作Service实现
* @createDate 2022-05-25 20:11:16
*/
@Service
public class RoleMenuServiceImpl extends ServiceImpl<RoleMenuMapper, RoleMenu>
    implements RoleMenuService{

}




