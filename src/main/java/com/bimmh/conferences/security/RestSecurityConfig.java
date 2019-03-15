package com.bimmh.conferences.security;

import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/*
@EnableWebMvcSecurity
@Configuration
*/
public class RestSecurityConfig extends WebSecurityConfigurerAdapter {
/*    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .permitAll();
    }*/
}