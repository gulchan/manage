package com.gulchan.manage.servlet;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class FisrtListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("FisrtListener 监听到 ServletContext 初始化");
    }
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("FisrtListener 监听到 ServletContext 销毁");
    }
}
