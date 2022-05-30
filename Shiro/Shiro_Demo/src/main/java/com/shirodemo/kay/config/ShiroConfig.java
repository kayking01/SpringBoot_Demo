package com.shirodemo.kay.config;


import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {
    //ShiroFilterFactoryBean：3
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("SecurityManage") DefaultWebSecurityManager defaultWebSecurityManager){
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        // 设置安全管理器
        bean.setSecurityManager(defaultWebSecurityManager);
        //添加shiro的内置过滤器
        /*
            anon: 无需认证就可以访问
            authc：必须认证才可以访问
            user：必须有记住我功能才能使用
            perms：拥有对某个资源的权限才能访问
            role：拥有某个角色权限才能访问

        filterMap.put("/shiro/user/add","authc");
        filterMap.put("/shiro/user/update","authc");
        */
        // 拦截  授权和认证放在Realm类中
        Map<String, String> filterMap = new LinkedHashMap<>();
        // 授权（放在前面，否则（会失效）重复的map key 只会put第一个）
        filterMap.put("/shiro/user/add","perms[user:add]");
        filterMap.put("/shiro/user/update","perms[user:update]");
        // 拦截
        filterMap.put("/shiro/user/*","authc");  // 支持通配符
        bean.setFilterChainDefinitionMap(filterMap);

        //设置 登录页面 （没有权限时，会跳到登陆界面）
        bean.setLoginUrl("/shiro/toLogin");
        //设置 未授权页面（没有设置时，会报401错误（未授权））
        bean.setUnauthorizedUrl("/shiro/unauth");


        return bean;
    }
    //DefaultWebSecurityManage: 2
    @Bean(name="SecurityManage")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm){
        DefaultWebSecurityManager SecurityManage = new DefaultWebSecurityManager();
        SecurityManage.setRealm(userRealm);  // 关联 Realm
        return SecurityManage;
    }
    // 创建 Realm对象  需要自定义类：1
    @Bean
    public UserRealm userRealm(){
        return new UserRealm();
    }

    //ShiroDialect ： 整合 shiro thymeleaf
    @Bean
    public ShiroDialect getShiroDialect(){
        return new ShiroDialect();
    }
}
