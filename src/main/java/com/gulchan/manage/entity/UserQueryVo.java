package com.gulchan.manage.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="用户信息查询对象",description = "便于扩充")
public class UserQueryVo {
    @ApiModelProperty("用户名")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "UserQueryVo{" +
                "name='" + name + '\'' +
                '}';
    }
}
