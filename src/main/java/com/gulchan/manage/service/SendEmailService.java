package com.gulchan.manage.service;

import com.gulchan.manage.pojo.User;

import java.util.List;

public interface SendEmailService {
    boolean sendEmail(List<User> userList);
}
