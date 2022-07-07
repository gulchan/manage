package com.gulchan.manage.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.models.auth.In;

/**
 * 请求响应实体
 * @param <T> 响应数据对象
 */
@ApiModel(value="响应对象",description = "")
public class JsonObject <T>{
    @ApiModelProperty("提醒信息")
    private String msg;

    @ApiModelProperty("状态码值")
    private Integer code;

    @ApiModelProperty("响应实际数据")
    private T data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public JsonObject() {
    }

    public JsonObject(String msg) {
        this.msg = msg;
        this.code = ResponseCode.SUCCESS;
    }


    public JsonObject(String msg, Integer code) {
        this.msg = msg;
        this.code = code;
    }

    public JsonObject(String msg, Integer code,T t) {
        this.msg = msg;
        this.code = code;
        this.data = t;
    }

    @Override
    public String toString() {
        return "JsonObject{" +
                "msg='" + msg + '\'' +
                ", code=" + code +
                ", data=" + data +
                '}';
    }
}
