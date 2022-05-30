package com.shirodemo.kay.config;


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
        filterMap.put("/shiro/user/*","authc");  // 支持通配符
        bean.setFilterChainDefinitionMap(filterMap);
        //设置 登录页面 （没有权限时，会跳到登陆界面）
        bean.setLoginUrl("/shiro/toLogin");

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
}
