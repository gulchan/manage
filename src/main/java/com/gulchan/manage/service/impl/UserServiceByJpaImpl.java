package com.gulchan.manage.service.impl;

import com.gulchan.manage.pojo.User;
import com.gulchan.manage.repository.UserRepository;
import com.gulchan.manage.service.UserServiceByJpa;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceByJpaImpl implements UserServiceByJpa {
    @Resource
    private UserRepository userRepository;

    @Override
    public User findById(String id) {
        return userRepository.findById(id).get();
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public void delete(String id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<User> findByName(String name) {
        return userRepository.findByName(name);
    }

    @Override
    public List<User> findByNameLike(String name) {
        return userRepository.findByNameLike(name);
    }

    @Override
    public User findByNameAndPwd(String name, String password) {
        return userRepository.findByNameAndPwd(name,password);
    }
}
