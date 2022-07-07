package com.gulchan.manage.service.impl;

import com.gulchan.manage.pojo.Job;
import com.gulchan.manage.dao.JobMapper;
import com.gulchan.manage.service.JobService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 工作信息 服务实现类
 * </p>
 *
 * @author gulchan
 * @since 2022-06-10
 */
@Service
public class JobServiceImpl extends ServiceImpl<JobMapper, Job> implements JobService {

}
