package com.gulchan.manage.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="查询对象")
public class HrQueryVo {
    @ApiModelProperty("联系人名")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "HrQueryVo{" +
                "name='" + name + '\'' +
                '}';
    }
}
