package com.spring.base.service.impl;

import com.spring.base.model.user.BlogUserRole;
import com.spring.base.dao.user.mapper.BlogUserRoleMapper;
import com.spring.base.service.BlogUserRoleService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户角色表 服务实现类
 * </p>
 *
 * @author hinzzz
 * @since 2019-10-14
 */
@Service
public class BlogUserRoleServiceImpl extends ServiceImpl<BlogUserRoleMapper, BlogUserRole> implements BlogUserRoleService {

}
