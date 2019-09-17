package com.spring.base.service;

import com.spring.base.model.UserInfo;

public interface UserInfoSeveice {

    UserInfo getUserInfoById(String err);

    int updateUserInfo(Long id);
}
