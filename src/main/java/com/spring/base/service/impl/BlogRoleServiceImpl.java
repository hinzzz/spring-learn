package com.spring.base.service.impl;

import com.spring.base.model.user.BlogRole;
import com.spring.base.dao.user.mapper.BlogRoleMapper;
import com.spring.base.service.BlogRoleService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @author hinzzz
 * @since 2019-10-14
 */
@Service
public class BlogRoleServiceImpl extends ServiceImpl<BlogRoleMapper, BlogRole> implements BlogRoleService {

}
