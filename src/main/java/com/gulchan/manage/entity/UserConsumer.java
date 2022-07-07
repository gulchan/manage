package com.gulchan.manage.entity;

import com.gulchan.manage.pojo.User;
import com.gulchan.manage.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class UserConsumer {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private UserService userService;

    /**
     * 消费者监听指定的消息队列
     * @param text
     */
    @JmsListener(destination = "my.queue")
    public void receiveQueue1(String text){
        logger.info("消费者1---消费了消息：\n" + text);
    }

    /**
     * 消费者监听指定的消息队列
     * @param text
     */
    @JmsListener(destination = "my.queue")
    public void receiveQueue2(String text){
        logger.info("消费者2---消费了消息：\n" + text);
    }


    @JmsListener(destination = "user.queue.aysn.save")
    public void asynSaveUser(User user){
        userService.save(user);
    }

    @JmsListener(destination = "my.topic")
    public void someMessageHandle1(String text){
        logger.info("订阅1---接收到广播信息：\n" + text);
    }


    @JmsListener(destination = "my.topic")
    public void someMessageHandle2(String text){
        logger.info("订阅2---接收到广播信息：\n" + text);
    }


}
