package com.prongbang.moni.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 *
 * @author prongbang
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    //@Autowired DataSource dataSource;
    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {

        // other authen
        auth.authenticationProvider(new UserAuthenticationProvider()); 

        // jdbc authen
        /*
         auth.jdbcAuthentication().dataSource(dataSource)
         .usersByUsernameQuery("select username,password, enabled from users where username=?")
         .authoritiesByUsernameQuery("select username, role from user_roles where username=?");
         */
        
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        
        http.authorizeRequests()
                .antMatchers("/*").permitAll()
                .antMatchers("/login*").permitAll()
                .antMatchers("/home*").access("isAuthenticated()")
                .antMatchers("/book*").access("isAuthenticated() and hasAnyRole('ADMIN', 'USER')")
                .and()
                .formLogin().loginPage("/login")
                .successHandler(new UserAuthenticationSuccessHandler())
                .failureUrl("/login?rs=error")
                .defaultSuccessUrl("/home")
                .usernameParameter("j_username")
                .passwordParameter("j_password")
                .and()
                .logout().logoutSuccessUrl("/login?rs=logout").deleteCookies("JSESSIONID")
                .and()
                .exceptionHandling().accessDeniedPage("/403")
                .and()
                .sessionManagement()
                .invalidSessionUrl("/login?rs=expired")
                .sessionAuthenticationErrorUrl("/login?rs=error")
                .and()
                .csrf();
    }

}
