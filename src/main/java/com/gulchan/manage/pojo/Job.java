package com.gulchan.manage.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 工作信息
 * </p>
 *
 * @author gulchan
 * @since 2022-06-10
 */
@TableName("job")
public class Job implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 工作唯一标识
     */
    @TableId(value = "id")
    private String id;

    /**
     * 工作推荐人
     */
    private String hrid;

    /**
     * 工作名称
     */
    private String name;

    /**
     * 工作所属的单位
     */
    private String unit;

    /**
     * 工作地址
     */
    private String address;

    /**
     * 工作时间安排
     */
    private String worktime;

    /**
     * 福利待遇说明
     */
    private String welfare;

    /**
     * 工资说明
     */
    private String salary;

    /**
     * 工作职责说明
     */
    private String descrip;

    /**
     * 技能要求
     */
    private String skill;

    /**
     * 工作状态；已回绝；待面试；面试失败；待复试；得到offer
     */
    private String state;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHrid() {
        return hrid;
    }

    public void setHrid(String hrid) {
        this.hrid = hrid;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getWorktime() {
        return worktime;
    }

    public void setWorktime(String worktime) {
        this.worktime = worktime;
    }

    public String getWelfare() {
        return welfare;
    }

    public void setWelfare(String welfare) {
        this.welfare = welfare;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Job{" +
        "id=" + id +
        ", hrid=" + hrid +
        ", name=" + name +
        ", unit=" + unit +
        ", address=" + address +
        ", worktime=" + worktime +
        ", welfare=" + welfare +
        ", salary=" + salary +
        ", descrip=" + descrip +
        ", skill=" + skill +
        ", state=" + state +
        "}";
    }
}
