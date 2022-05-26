package com.shirodemo.kay.controller;

import com.shirodemo.kay.entity.Menu;
import com.shirodemo.kay.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;

//@RestController
//@RequestMapping("/test")
public class testController {

    @Autowired
    MenuService menuService;

//    @RequestMapping("/1")
    public Menu test(){
        return menuService.getById(2);
    }
}
