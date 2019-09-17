package com.spring.base.service.impl;


import com.spring.base.dao.UserInfoMapper;
import com.spring.base.exception.TransactionException;
import com.spring.base.exception.UnKnowException;
import com.spring.base.exception.UserInfoException;
import com.spring.base.model.UserInfo;
import com.spring.base.service.UserInfoSeveice;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author quanhz
 */
@Service
public class UserInfoServiceImpl implements UserInfoSeveice {

    @Resource
    private UserInfoMapper userInfoMapper ;

    @Override
    public UserInfo getUserInfoById(String id) {
        if("1".equals(id)){
            throw new UserInfoException("用户信息异常");
        }else if("2".equals(id)){
            throw new UnKnowException("未知异常");
        }else if("3".equals(id)){
            throw new NullPointerException("空指针");
        }


        return userInfoMapper.getUserInfoById(Long.valueOf(id));
    }

    @Transactional(rollbackFor = TransactionException.class)
    @Override
    public int updateUserInfo(Long id) {
        userInfoMapper.updateUserInfo(id,"gg");

        if(id==1){
            throw new TransactionException("测试事务异常");
        }
        userInfoMapper.updateUserInfo(1L,"mm");
        return 1;
    }
}
