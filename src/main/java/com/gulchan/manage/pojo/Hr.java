package com.gulchan.manage.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;

/**
 * <p>
 * 求职联系人
 * </p>
 *
 * @author gulchan
 * @since 2022-06-10
 */
@TableName("hr")
public class Hr implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 联系人唯一标识
     */
    @TableId(value = "id")
    private String id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 所属公司
     */
    private String unit;

    /**
     * 联系方式
     */
    private String contact;

    /**
     * 性别
     */
    private String sex;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createtime;

    /**
     * 创建用户
     */
    private String createuser;

    /**
     * 更新时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updatetime;

    /**
     * 更新日期
     */
    private String updateuser;


    public Hr() {
    }

    public Hr(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getCreateuser() {
        return createuser;
    }

    public void setCreateuser(String createuser) {
        this.createuser = createuser;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public String getUpdateuser() {
        return updateuser;
    }

    public void setUpdateuser(String updateuser) {
        this.updateuser = updateuser;
    }

    @Override
    public String toString() {
        return "Hr{" +
        "id=" + id +
        ", name=" + name +
        ", unit=" + unit +
        ", contact=" + contact +
        ", sex=" + sex +
        ", createtime=" + createtime +
        ", createuser=" + createuser +
        ", updatetime=" + updatetime +
        ", updateuser=" + updateuser +
        "}";
    }
}
