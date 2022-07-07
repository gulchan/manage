package com.gulchan.manage.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;

/**
 * <p>
 * 面试记录表
 * </p>
 *
 * @author gulchan
 * @since 2022-06-10
 */
@TableName("interview")
public class Interview implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 面试记录唯一标识
     */
    @TableId(value = "id")
    private String id;

    /**
     * 所属工作
     */
    private String jobid;

    /**
     * 面试官姓名
     */
    private String name;

    /**
     * 面试时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date intertime;

    /**
     * 面试交谈内容
     */
    private String content;

    /**
     * 面试最终的结果
     */
    private String state;

    /**
     * 求职人员
     */
    private String userid;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJobid() {
        return jobid;
    }

    public void setJobid(String jobid) {
        this.jobid = jobid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getIntertime() {
        return intertime;
    }

    public void setIntertime(Date intertime) {
        this.intertime = intertime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    @Override
    public String toString() {
        return "Interview{" +
        "id=" + id +
        ", jobid=" + jobid +
        ", name=" + name +
        ", intertime=" + intertime +
        ", content=" + content +
        ", state=" + state +
        ", userid=" + userid +
        "}";
    }
}
