package com.kucw.security.security;

import jakarta.servlet.*;

import java.io.IOException;

public class MyFilter1 implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("執行 MyFilter1");

        //必須加入 才能加給下一個filter
        chain.doFilter(request,response);
    }
}
