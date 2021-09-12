package com.huatech.security;

import lombok.extern.slf4j.Slf4j;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.annotation.Resource;

/**
 * @description: security登录配置
 * @author: SongXY
 * @create: 2021-07-25 17:08
 **/
@Configuration
@Slf4j
public class MyWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {
    @Resource
    private MyAuthenticationSuccessHandler successHandler;
    @Resource
    private MyAuthenticationFailureHandler failureHandler;
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        log.info("configure: 登录成功");
        http.formLogin()
                //登录的请求方法
                .loginPage("/login")
                //登录成功相应给前台的内容
                .successHandler(successHandler)
                .failureHandler(failureHandler)
                .and()
                .authorizeRequests()
                .anyRequest().permitAll()
                .and()
                .logout().permitAll()
                .and()
                .csrf().disable()
                .headers().frameOptions().disable();
    }
}
