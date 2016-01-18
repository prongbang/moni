package com.prongbang.moni.security;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 *
 * @author prongbang
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {

        // other authen
        //auth.authenticationProvider(new UserAuthenticationProvider());
        
        // jdbc authen 
        auth.jdbcAuthentication().dataSource(dataSource)
                .passwordEncoder(sha512PasswordEncoder())
                .usersByUsernameQuery("select username, password, enabled from users where username=?")
                .authoritiesByUsernameQuery("select username, role from user_roles where username=?");

    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder;
    }
    
    @Bean
    public ShaPasswordEncoder sha512PasswordEncoder(){
        // strength - EX: 1, 256, 384, 512
        ShaPasswordEncoder encoder = new ShaPasswordEncoder(512); 
        return encoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        // Web 
        http.authorizeRequests()
                .antMatchers("/login*").permitAll()
                .antMatchers("/home*").access("isAuthenticated()")
                .antMatchers("/book*").access("isAuthenticated() and hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
                .and()
                .formLogin().loginPage("/login")
                .successHandler(new UserAuthenticationSuccessHandler())
                .failureUrl("/login?error")
                .defaultSuccessUrl("/home")
                .usernameParameter("j_username")
                .passwordParameter("j_password")
                .and()
                .logout().logoutSuccessUrl("/login?logout").deleteCookies("JSESSIONID")
                .and()
                .exceptionHandling().accessDeniedPage("/403")
                .and()
                .sessionManagement()
                .invalidSessionUrl("/login?expired")
                .sessionAuthenticationErrorUrl("/login?error")
                .and()
                .csrf();
        // http.csrf().disable(); // use ajax not send csrf
        
        // Webservice
//        http.authorizeRequests()
//                .antMatchers("/service/login").permitAll()
//                .antMatchers("/service*").access("isAuthenticated()")
//                .and()
//                .addFilter(new AuthenticationFilter())
//                .csrf().disable();
    }

}
