package com.gulchan.manage.dao;

import com.gulchan.manage.pojo.UserRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 用户角色关联表

 Mapper 接口
 * </p>
 *
 * @author gulchan
 * @since 2022-06-10
 */
@Mapper
public interface UserRoleMapper extends BaseMapper<UserRole> {

}
