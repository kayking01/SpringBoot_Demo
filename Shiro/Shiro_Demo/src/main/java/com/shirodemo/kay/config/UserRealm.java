package com.shirodemo.kay.config;

import com.shirodemo.kay.entity.TestUser;
import com.shirodemo.kay.service.TestUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

// 自定义的UserRealm     extends AuthorizingRealm
public class UserRealm extends AuthorizingRealm {

    @Autowired
    TestUserService testUserService;
    // 授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行了授权");
        return null;
    }
    // 认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        TestUser testUser = testUserService.findByUsername(token.getUsername());
        if (testUser==null){
            return null;  // UnknownAccountException
        }
        // 可以加密：
        return new SimpleAuthenticationInfo("",testUser.getPassword(),"");
    }
}
