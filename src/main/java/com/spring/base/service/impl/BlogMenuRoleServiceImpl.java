package com.spring.base.service.impl;

import com.spring.base.model.user.BlogMenuRole;
import com.spring.base.dao.user.mapper.BlogMenuRoleMapper;
import com.spring.base.service.BlogMenuRoleService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 菜单角色表 服务实现类
 * </p>
 *
 * @author hinzzz
 * @since 2019-10-14
 */
@Service
public class BlogMenuRoleServiceImpl extends ServiceImpl<BlogMenuRoleMapper, BlogMenuRole> implements BlogMenuRoleService {

}
