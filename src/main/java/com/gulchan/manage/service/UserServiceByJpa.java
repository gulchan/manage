package com.gulchan.manage.service;

import com.gulchan.manage.pojo.User;

import java.util.List;

public interface UserServiceByJpa {

    User findById(String id);
    List<User> findAll();
    User save(User user);
    void delete(String id);
    List<User> findByName(String name);
    User findByNameAndPwd(String name,String pwd);
    List<User> findByNameLike(String name);

}
