package com.gulchan.manage.service.impl;

import com.gulchan.manage.pojo.Permission;
import com.gulchan.manage.dao.PermissionMapper;
import com.gulchan.manage.service.PermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 权限表 服务实现类
 * </p>
 *
 * @author gulchan
 * @since 2022-06-10
 */
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements PermissionService {

}
