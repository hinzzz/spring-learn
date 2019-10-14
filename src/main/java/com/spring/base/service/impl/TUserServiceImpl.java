package com.spring.base.service.impl;

import com.spring.base.model.user.TUser;
import com.spring.base.dao.user.mapper.TUserMapper;
import com.spring.base.service.TUserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hinzzz
 * @since 2019-10-14
 */
@Service
public class TUserServiceImpl extends ServiceImpl<TUserMapper, TUser> implements TUserService {

}
