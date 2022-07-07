package com.gulchan.manage.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 权限表
 * </p>
 *
 * @author gulchan
 * @since 2022-06-10
 */
@TableName("permission")
public class Permission implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "id")
    private String id;

    /**
     * 权限名
     */
    private String name;

    /**
     * 权限码值
     */
    private String code;

    /**
     * 权限描述
     */
    private String desp;

    /**
     * 权限地址
     */
    private String url;


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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesp() {
        return desp;
    }

    public void setDesp(String desp) {
        this.desp = desp;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Permission{" +
        "id=" + id +
        ", name=" + name +
        ", code=" + code +
        ", desp=" + desp +
        ", url=" + url +
        "}";
    }
}
