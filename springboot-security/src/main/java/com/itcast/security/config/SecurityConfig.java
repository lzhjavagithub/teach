package com.itcast.security.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.stereotype.Component;

@Component // 注入到spring容器中
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    // 继承WebSecurityConfigurerAdapter 做security核心的一些配置
    // 重写两个方法

    /**
     * 配置用户认证信息和权限
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("admin").password("123") // 设置用户名密码
                .authorities("add");//拥有的权限
    }

    /**
     * 配置拦截请求资源
     * @param http
     * @throws Exception
     */
   /*@Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/**")
                .fullyAuthenticated() // 拦截所有请求
                .and().formLogin();
                //.httpBasic();
    }*/

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 设置权限
        http.authorizeRequests()
                .antMatchers("/sec/add").hasAnyAuthority("add")
                .antMatchers("/sec/find").hasAnyAuthority("find")
                .antMatchers("/sec/update").hasAnyAuthority("update")
                .antMatchers("/sec/delete").hasAnyAuthority("delete")
                .antMatchers("/sec/login").permitAll() // 放行
                .antMatchers("/**").fullyAuthenticated()
                .and().formLogin().loginPage("/sec/login") // 登录页面
                .successForwardUrl("/sec/index").failureForwardUrl("/sec/login") // 登录成功和失败
                .and().csrf().disable(); // 跨站点攻击  默认关闭，禁止跨站点攻击
        //.httpBasic();
    }

}
