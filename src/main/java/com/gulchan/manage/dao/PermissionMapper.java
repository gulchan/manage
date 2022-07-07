package com.gulchan.manage.dao;

import com.gulchan.manage.pojo.Permission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 权限表 Mapper 接口
 * </p>
 *
 * @author gulchan
 * @since 2022-06-10
 */
@Mapper
public interface PermissionMapper extends BaseMapper<Permission> {

}
