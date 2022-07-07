package com.gulchan.manage.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="登录参数")
public class LoginEntity {
    @ApiModelProperty(value="用户名")
    private String name;

    @ApiModelProperty(value="密码")
    private String pwd;

    @ApiModelProperty(value="验证码",hidden = true)
    private String verifyCode;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }


    @Override
    public String toString() {
        return "LoginEntity{" +
                "name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                ", verifyCode='" + verifyCode + '\'' +
                '}';
    }
}
