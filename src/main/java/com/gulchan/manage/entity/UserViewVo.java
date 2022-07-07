package com.gulchan.manage.entity;

import com.gulchan.manage.pojo.User;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel(value="用户列表视图对象",description = "便于扩展属性")
public class UserViewVo {
    @ApiModelProperty(value="用户列表数据")
    private List<User> users;

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "UserViewVo{" +
                "users=" + users +
                '}';
    }
}
