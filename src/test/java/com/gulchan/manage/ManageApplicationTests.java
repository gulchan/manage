package com.gulchan.manage;

import cn.hutool.core.date.DateTime;
import com.gulchan.manage.pojo.User;
import com.gulchan.manage.service.UserProducer;
import com.gulchan.manage.service.UserService;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jms.core.JmsMessagingTemplate;

import javax.annotation.Resource;
import javax.jms.Destination;
import java.util.UUID;

@SpringBootTest
class ManageApplicationTests {

    @Resource
    private UserService userService;

    @Resource
    private UserProducer userProducer;

    @Resource
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Test
    void contextLoads() {
    }

    @Test
    public void testRegUser(){
        User user = new User();
        user.setAge(26);
        user.setId(UUID.randomUUID().toString());
        user.setCreatetime(DateTime.now());
        user.setName("高骞");
        user.setPwd("1");
        // 往数据库中存入一条数据
        Boolean b  = userService.save(user);
        System.out.println(b?"存入成功":"存入失败");
    }

    @Test
    public void testActiveMQ() {
        Destination destination = new ActiveMQQueue("my.queue");
        userProducer.sendMessage(destination,"this is my first messsage of ActiveMQ.");
    }


    @Test
    public void testUserQueueAsynSave(){
        User user = new User();
        user.setAge(26);
        user.setId(UUID.randomUUID().toString());
        user.setCreatetime(DateTime.now());
        user.setName("高骞");
        user.setPwd("1");
        // 往数据库中存入一条数据
        Boolean b  = userService.asynSave(user);
        System.out.println(b?"存入成功":"存入失败");
    }


    @Test
    public void testActiveMQTopic(){
        Destination destination = new ActiveMQTopic("my.topic");
        jmsMessagingTemplate.convertAndSend(destination,"the second topic");
    }


}
