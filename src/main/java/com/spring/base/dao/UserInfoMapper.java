package com.spring.base.dao;


import com.spring.base.model.UserInfo;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserInfoMapper {

    @Select("select * from t_user where id=#{id}")
    @ResultType(UserInfo.class)
    UserInfo getUserInfoById(@Param("id")Long id);

    @Update("update t_user set username=#{username} where id=#{id}")
    @ResultType(Integer.class)
    int updateUserInfo(@Param("id") Long id,@Param("username") String username);
}
