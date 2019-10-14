package com.spring.base.service.impl;

import com.spring.base.model.user.BlogMenu;
import com.spring.base.dao.user.mapper.BlogMenuMapper;
import com.spring.base.service.BlogMenuService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 菜单表 服务实现类
 * </p>
 *
 * @author hinzzz
 * @since 2019-10-14
 */
@Service
public class BlogMenuServiceImpl extends ServiceImpl<BlogMenuMapper, BlogMenu> implements BlogMenuService {

}
