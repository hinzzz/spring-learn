package com.spring.base.service.impl;


import com.spring.base.dao.base.xml.UserInfoMapper;
import com.spring.base.dao.other.OtherUserInfoMapper;
import com.spring.base.exception.TransactionException;
import com.spring.base.exception.UnKnowException;
import com.spring.base.exception.UserInfoException;
import com.spring.base.model.UserInfo;
import com.spring.base.service.UserInfoSeveice;
import com.spring.base.sys.datasource.DBType;
import com.spring.base.sys.datasource.DataSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author quanhz
 */

@Service
public class UserInfoServiceImpl implements UserInfoSeveice {

    @Resource
    private UserInfoMapper userInfoMapper;
    @Resource
    private OtherUserInfoMapper otherUserInfoMapper;

    @Override
    public UserInfo getUserInfoById(String id) {
        if ("1".equals(id)) {
            throw new UserInfoException("用户信息异常");
        } else if ("2".equals(id)) {
            throw new UnKnowException("未知异常");
        } else if ("3".equals(id)) {
            throw new NullPointerException("空指针");
        }
        return userInfoMapper.getUserInfoById(Long.valueOf(id));
    }

    @Transactional(rollbackFor = TransactionException.class, value = "masterTransactionManager")
    @Override
    public int updateUserInfo(Long id) {
        System.out.println("userInfoMapper = " + userInfoMapper);
        userInfoMapper.updateUserInfo(id, "gg");
        userInfoMapper.updateUserInfo(3L, "mm");
        if (id == 1) {
            throw new TransactionException("事务异常");
        }
        return 1;
    }


    @DataSource(DBType.OTHER)
    @Transactional(transactionManager = "otherTransactionManager")
    @Override
    public void update1(Long id) {
        otherUserInfoMapper.updateUserInfo(id,"other");
    }
    @Transactional(transactionManager = "masterTransactionManager")
    @DataSource(DBType.MASTER)
    @Override
    public void update2(Long id) {
        otherUserInfoMapper.updateUserInfo(id,"master");
    }


    @DataSource(DBType.OTHER)
    @Transactional(transactionManager = "otherTransactionManager")
    public UserInfo get(Long id){
        return otherUserInfoMapper.getUserInfoById(id);
    }

}
