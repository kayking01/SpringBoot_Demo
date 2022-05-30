package com.shirodemo.kay.controller;

import com.shirodemo.kay.test.Quickstart;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/shiro")
public class MyController {
    private static final transient Logger log = LoggerFactory.getLogger(Quickstart.class);
    @RequestMapping({"/index","/"})
    public String index(Model model){
        model.addAttribute("msg","hello,shiro");
        return "index";
    }
    @RequestMapping("toLogin")
    public String toLogin(){
        return "login";
    }

    @RequestMapping("/user/add")
    public String add(){
        return "user/add";
    }

    @RequestMapping("/user/update")
    public String update(){
        return "user/update";
    }

    @RequestMapping("/login")
    public String login(String name,String password,Model model){
        // 获取当前用户
        Subject subject = SecurityUtils.getSubject();
        // 封装用户登陆数据
        UsernamePasswordToken token = new UsernamePasswordToken(name, password);
        try {
            subject.login(token);  // 执行登陆方法，如果没有异常说明ok了
            return "index";
        } catch (UnknownAccountException uae) {
            log.info("There is no user with username of " +  token.getPrincipal());
            model.addAttribute("msg","账户错误");
            return "login";
        }catch (IncorrectCredentialsException ice){
            log.info("Password for account " + token.getPrincipal() + " was incorrect!");
            model.addAttribute("msg","密码错误");
            return "login";
        }
    }

    @RequestMapping("/unauth")
    @ResponseBody
    public String unauthorized(){
        return "未授权操作";
    }
}
