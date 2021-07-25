package com.example.springsecuritytest.config;

import ch.qos.logback.core.pattern.color.BoldCyanCompositeConverter;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

// security配置类
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 授权
        // 首页所有人可以访问，功能页只有对应有权限的人才能访问
        http.authorizeRequests()
                .antMatchers("/","/toLogin","/loginget").permitAll()//首页和登陆所有人可以访问
                .antMatchers("/level1/**").hasRole("vip1")
                .antMatchers("/level2/**").hasRole("vip2")
                .antMatchers("/level3/**").hasRole("vip3")
                .and()
                .csrf().disable()//关闭csrf
                .formLogin().loginPage("/toLogin")//自定义登陆页面跳转
                .defaultSuccessUrl("/index") //登陆成功跳转页面
                .and()
                .httpBasic().disable();
        http.logout();//注销
        //http.formLogin().loginProcessingUrl("/toLogin").permitAll();//跳回登陆,如果没有配置，这个登陆页面是security的登陆页面
    }

    // 认证
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 这里是直接设置用户，后面也是可以从数据库获取
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                .withUser("11").password(new BCryptPasswordEncoder().encode("11")).roles("vip1", "vip2")
                .and()
                .withUser("22").password(new BCryptPasswordEncoder().encode("22")).roles("vip1", "vip2", "vip3");

    }
}
