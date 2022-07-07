package com.gulchan.manage.servlet;

import com.gulchan.manage.utils.IpAddressUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

@WebFilter(filterName = "firstFilter",urlPatterns = "/user/*")
public class FirstFilter implements Filter {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Value(value = "${disableHost}")
    private String [] disableHost;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        logger.info("-----------first Filter doFilter...---------");
        logger.info("remoteHost:" + request.getRemoteHost());
        logger.info("remoteAddr:" + request.getRemoteAddr());
        logger.info("localAddr:" + request.getLocalAddr());
        String ip = IpAddressUtil.getIpAddress(request instanceof HttpServletRequest?(HttpServletRequest) request:null);
        logger.info("ip:" + ip);
        long count = Arrays.stream(this.disableHost).filter(item->item.equals(ip)).count();
        if(count==0){
            // 不是
            chain.doFilter(request,response);
        }else{
            response.getOutputStream().write("拒绝访问".getBytes(StandardCharsets.UTF_8));
        }

    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("-----------first Filter init...---------");
        Arrays.stream(this.disableHost).forEach(logger::info);
        Filter.super.init(filterConfig);
    }

    @Override
    public void destroy() {
        logger.info("-----------first Filter destory...---------");
        Filter.super.destroy();
    }
}
