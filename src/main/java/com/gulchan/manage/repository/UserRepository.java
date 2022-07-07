package com.gulchan.manage.repository;

import com.gulchan.manage.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface UserRepository extends JpaRepository<User,String> {

    List<User> findByName(String name);
    List<User> findByNameLike(String name);
    List<User> findByIdIn(Collection<String> ids);
    User findByNameAndPwd(String name,String pwd);
}
