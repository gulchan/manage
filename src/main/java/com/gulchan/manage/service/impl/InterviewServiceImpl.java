package com.gulchan.manage.service.impl;

import com.gulchan.manage.pojo.Interview;
import com.gulchan.manage.dao.InterviewMapper;
import com.gulchan.manage.service.InterviewService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 面试记录表 服务实现类
 * </p>
 *
 * @author gulchan
 * @since 2022-06-10
 */
@Service
public class InterviewServiceImpl extends ServiceImpl<InterviewMapper, Interview> implements InterviewService {

}
