package com.shirodemo.kay.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shirodemo.kay.entity.Menu;
import com.shirodemo.kay.service.MenuService;
import com.shirodemo.kay.mapper.MenuMapper;
import org.springframework.stereotype.Service;

/**
* @author kay
* @description 针对表【sys_menu(菜单管理)】的数据库操作Service实现
* @createDate 2022-05-25 19:59:10
*/
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu>
    implements MenuService{

}




