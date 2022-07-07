package com.gulchan.manage.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 角色权限关联表


 * </p>
 *
 * @author gulchan
 * @since 2022-06-10
 */
@TableName("role_permission")
public class RolePermission implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 角色id
     */
    @TableId(value = "roleid")
    private String roleid;

    /**
     * 权限id
     */
    private String permid;


    public String getRoleid() {
        return roleid;
    }

    public void setRoleid(String roleid) {
        this.roleid = roleid;
    }

    public String getPermid() {
        return permid;
    }

    public void setPermid(String permid) {
        this.permid = permid;
    }

    @Override
    public String toString() {
        return "RolePermission{" +
        "roleid=" + roleid +
        ", permid=" + permid +
        "}";
    }
}
