package com.spring.base.sys.security.service.impl;


import com.spring.base.sys.security.constant.RoleConstant;
import com.spring.base.sys.security.mapper.UserMapper;
import com.spring.base.sys.security.model.UserEntity;
import com.spring.base.sys.security.service.UserService;
import org.springframework.context.annotation.Primary;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Primary
public class BaseUserService implements UserService {

    private final UserMapper userMapper;

    public BaseUserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public boolean insert(UserEntity userEntity) {
        String username = userEntity.getUsername();
        if (exist(username)) {
            return false;
        }
        encryptPassword(userEntity);
        userEntity.setRoles(RoleConstant.ROLE_USER);
        int result = userMapper.insert(userEntity);
        return result == 1;
    }

    @Override
    public UserEntity getByUsername(String username) {
        return userMapper.selectByUsername(username);
    }

    /**
     * 判断用户是否存在
     *
     * @param username 账号
     * @return 密码
     */
    private boolean exist(String username) {
        UserEntity userEntity = userMapper.selectByUsername(username);
        return (userEntity != null);
    }

    /**
     * 加密密码
     */
    private void encryptPassword(UserEntity userEntity) {
        String password = userEntity.getPassword();
        password = new BCryptPasswordEncoder().encode(password);
        userEntity.setPassword(password);
    }

}
