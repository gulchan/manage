package com.gulchan.manage.service.impl;

import com.gulchan.manage.service.UserProducer;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.Destination;

/**
 * 消息生产者，用于往消息队列中存入消息
 */
@Service
public class UserProducerImpl implements UserProducer {

    @Resource
    private JmsMessagingTemplate jmsMessagingTemplate;


    @Override
    public void sendMessage(Destination destination, String message) {
        jmsMessagingTemplate.convertAndSend(destination,message);
    }
}
