package com.gulchan.manage.service;

import com.gulchan.manage.pojo.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author gulchan
 * @since 2022-06-10
 */
public interface UserService extends IService<User> {

    /**
     * 异步保存用户，用消息队列实现
     * @param user
     * @return
     */
    public boolean asynSave(User user);

}
