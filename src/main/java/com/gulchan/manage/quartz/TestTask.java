package com.gulchan.manage.quartz;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class TestTask {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public void run(){
        logger.info("定时器testTask运行了" + System.currentTimeMillis());
    }
}
