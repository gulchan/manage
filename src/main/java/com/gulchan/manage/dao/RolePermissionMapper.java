package com.gulchan.manage.dao;

import com.gulchan.manage.pojo.RolePermission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 角色权限关联表

 Mapper 接口
 * </p>
 *
 * @author gulchan
 * @since 2022-06-10
 */
@Mapper
public interface RolePermissionMapper extends BaseMapper<RolePermission> {

}
