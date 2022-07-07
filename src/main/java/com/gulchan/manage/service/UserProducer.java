package com.gulchan.manage.service;


import javax.jms.Destination;

public interface UserProducer {

    public void sendMessage(Destination destination, final String message);

}
