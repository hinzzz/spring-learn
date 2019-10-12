package com.spring.base.dao.other;


import com.spring.base.model.UserInfo;

@Mapper
public interface OtherUserInfoMapper {

    @Select("select * from t_user where id=#{id}")
    @ResultType(UserInfo.class)
    UserInfo getUserInfoById(@Param("id") Long id);

    @Update("update t_user set username=#{username} where id=#{id}")
    @ResultType(Integer.class)
    int updateUserInfo(@Param("id") Long id, @Param("username") String username);

}
