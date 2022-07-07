package com.gulchan.manage.entity;

import com.gulchan.manage.pojo.Hr;
import com.gulchan.manage.pojo.User;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel(value="联系人列表视图对象",description = "便与扩展其他属性")
public class HrViewVo {
    @ApiModelProperty(value="用户列表数据")
    private List<Hr> hrs;

    public List<Hr> getHrs() {
        return hrs;
    }

    public void setHrs(List<Hr> hrs) {
        this.hrs = hrs;
    }


    @Override
    public String toString() {
        return "HrViewVo{" +
                "hrs=" + hrs +
                '}';
    }
}
