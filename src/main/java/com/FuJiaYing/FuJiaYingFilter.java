package com.FuJiaYing.lab2;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;


public class FuJiaYingFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("FuJiaYingFilter-->before chain");
        chain.doFilter(req, resp);
        System.out.println("FuJiaYingFilter-->after chain");
    }

    public void init(FilterConfig config) throws ServletException {

    }

}