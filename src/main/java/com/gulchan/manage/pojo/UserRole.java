package com.gulchan.manage.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 用户角色关联表


 * </p>
 *
 * @author gulchan
 * @since 2022-06-10
 */
@TableName("user_role")
public class UserRole implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 用户id
     */
    @TableId(value = "userid")
    private String userid;

    /**
     * 角色id
     */
    private String roleid;


    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getRoleid() {
        return roleid;
    }

    public void setRoleid(String roleid) {
        this.roleid = roleid;
    }

    @Override
    public String toString() {
        return "UserRole{" +
        "userid=" + userid +
        ", roleid=" + roleid +
        "}";
    }
}
