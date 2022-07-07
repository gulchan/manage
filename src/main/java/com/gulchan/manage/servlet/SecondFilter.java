package com.gulchan.manage.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

//@WebFilter(filterName = "secondFilter",urlPatterns = "/user/*")
public class SecondFilter implements Filter {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        logger.info("-----------second Filter doFilter...---------");
        chain.doFilter(request,response);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("-----------second Filter init...---------");
        Filter.super.init(filterConfig);
    }

    @Override
    public void destroy() {
        logger.info("-----------second Filter destory...---------");
        Filter.super.destroy();
    }
}
