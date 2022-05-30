package com.shirodemo.kay.config;

import com.shirodemo.kay.entity.TestUser;
import com.shirodemo.kay.service.TestUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

// 自定义的UserRealm     extends AuthorizingRealm
public class UserRealm extends AuthorizingRealm {

    @Autowired
    TestUserService testUserService;
    // 授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行了授权");
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
//        // 此时 所有的用户都有 “user:add” 权限；---》 从数据库取
//        info.addStringPermission("user:add");

        // 拿到当前登录的用户
        Subject subject = SecurityUtils.getSubject();
        TestUser currentTestUser = (TestUser) subject.getPrincipal();// 拿到的是： 认证函数中 返回的 第一个参数principal  :return new SimpleAuthenticationInfo(principal,credentials,realmName);
        info.addStringPermission(currentTestUser.getPerms());  // 从数据库中 读取权限

        return info;
    }
    // 认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        TestUser testUser = testUserService.findByUsername(token.getUsername());
        if (testUser==null){
            return null;  // UnknownAccountException
        }
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        session.setAttribute("loginUser",testUser);
        // 可以加密：
        return new SimpleAuthenticationInfo(testUser,testUser.getPassword(),"");
    }
}
