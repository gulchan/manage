package com.gulchan.manage.service.impl;

import com.gulchan.manage.pojo.User;
import com.gulchan.manage.dao.UserMapper;
import com.gulchan.manage.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.jms.Destination;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author gulchan
 * @since 2022-06-10
 */
@Transactional
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Resource
    private JmsMessagingTemplate jmsMessagingTemplate;

    private static Destination destination = new ActiveMQQueue("user.queue.asyn.save");

    @Override
    public boolean asynSave(User user) {
        jmsMessagingTemplate.convertAndSend(destination,user);
        return true;
    }
}
