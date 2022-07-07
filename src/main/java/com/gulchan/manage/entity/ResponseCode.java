package com.gulchan.manage.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="响应码值枚举",description = "")
public class ResponseCode {
    @ApiModelProperty(value="成功")
    public static final Integer SUCCESS = 200;

    @ApiModelProperty(value="服务器内部错误")
    public static final Integer FAILURE = 500;

}
