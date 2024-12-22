package com.kucw.security.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class MyFilter2 extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        System.out.println("執行 MyFilter 2");

        String uri = request.getRequestURI();

        if(uri.equals("/hello")) {
            System.out.println("Path is /hello pass");
            //必須加入 才能加給下一個filter
            filterChain.doFilter(request,response);
        }else{
            System.out.println("Path is not /hello pass");
            //return response to front-end
            response.setStatus(500);
        }


    }
}
