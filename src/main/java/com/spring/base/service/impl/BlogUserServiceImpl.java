package com.spring.base.service.impl;

import com.spring.base.model.user.BlogUser;
import com.spring.base.dao.user.mapper.BlogUserMapper;
import com.spring.base.service.BlogUserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author hinzzz
 * @since 2019-10-14
 */
@Service
public class BlogUserServiceImpl extends ServiceImpl<BlogUserMapper, BlogUser> implements BlogUserService {

}
