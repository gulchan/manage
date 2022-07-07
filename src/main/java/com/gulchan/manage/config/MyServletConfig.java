package com.gulchan.manage.config;

import com.gulchan.manage.servlet.SecondFilter;
import com.gulchan.manage.servlet.SecondListener;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class MyServletConfig {

    /**
     * 过滤器的注册
     * @return
     */
    @Bean
    public FilterRegistrationBean SecondFilter(){
        SecondFilter secondFilter = new SecondFilter();
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(secondFilter);
        //注册该过滤器需要过滤的 url
        filterRegistrationBean.setUrlPatterns(Arrays.asList("/user/*"));
        return filterRegistrationBean;
    }

    /**
     * 监听器的注册
     * @return
     */
    @Bean
    public ServletListenerRegistrationBean secondListener(){
        SecondListener secondListener = new SecondListener();
        ServletListenerRegistrationBean servletListenerRegistrationBean = new ServletListenerRegistrationBean(secondListener);
        return servletListenerRegistrationBean;
    }
}
