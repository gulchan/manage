package com.gulchan.manage.quartz;

import com.gulchan.manage.pojo.User;
import com.gulchan.manage.service.SendEmailService;
import com.gulchan.manage.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

/**
 * 邮件发送的任务类
 */
@Component
@Configurable
@EnableScheduling
public class SendMailQuartz {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SendEmailService sendEmailService;


    @Resource
    private UserService userService;

//    @Scheduled(cron="*/5 * * * * *")
//    public void reportCurrentByCorn(){
//        logger.info("定时器“"+this.getClass().getName()+"”运行了");
//    }

    /**
     * 每年7.4号 15：32分 发送邮件
     */
    @Scheduled(cron="0 58 16 4 7 ?")
    public void sendMail(){
        List<User> userList = userService.list();
        if(Objects.isNull(userList) || userList.isEmpty()) return;
        sendEmailService.sendEmail(userList);
        logger.info("定时器sendMail运行了");
    }
}
