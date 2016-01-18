/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prongbang.moni.security;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import org.springframework.web.filter.GenericFilterBean;

/**
 *
 * @author prongbang
 */
//public class AuthenticationFilter extends GenericFilterBean {
public class AuthenticationFilter {

    private static final String HEADER_TOKEN = "X-Auth-Token";
    private static final String HEADER_USERNAME = "X-Username";
    private static final String HEADER_PASSWORD = "X-Password";

    /*
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        checkLogin(httpRequest,httpResponse);
        
        chain.doFilter(request, response);
    }
    */

    private void checkLogin(HttpServletRequest httpRequest, HttpServletResponse httpResponse) throws IOException {
        
        String username = httpRequest.getHeader(HEADER_USERNAME);
        String password = httpRequest.getHeader(HEADER_PASSWORD);
        
        System.out.println(username + " " + password);
        
    }

}
