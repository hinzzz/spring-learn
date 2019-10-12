package com.spring.base.controller;

import com.spring.base.base.BaseResult;
import com.spring.base.dao.other.OtherUserInfoMapper;
import com.spring.base.model.UserInfo;
import com.spring.base.service.UserInfoSeveice;
import com.spring.base.sys.datasource.DBType;
import com.spring.base.sys.datasource.DataSource;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.misc.ProxyGenerator;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileOutputStream;

/**
 * @author ：quanhz
 * @date ：Created in 2019/9/26 9:26
 */

@RequestMapping("/other")
@Controller
public class OtherController {

    @Resource
    private OtherUserInfoMapper otherUserInfoMapper;

    @Resource
    private UserInfoSeveice userInfoSeveice;


    @DataSource(DBType.OTHER)
    @RequestMapping("/getUser/{id}")
    @ResponseBody
    public BaseResult getUser(@PathVariable("id") Long id){
        UserInfo info = otherUserInfoMapper.getUserInfoById(id);
        return BaseResult.success("获取用户成功",info);
    }




    //@DataSource(DBType.OTHER)
    @RequestMapping("/updateUser/{id}/{username}/{t}")
    @ResponseBody
    public BaseResult updateUser(@PathVariable("id") Long id,@PathVariable("username")String username,@PathVariable("t")Integer t)throws Exception{
        /*userInfoSeveice.update1(id);
        userInfoSeveice.update2(id);*/
        update1(1L);
        update2(1L);
        byte[] bts = ProxyGenerator.generateProxyClass("$Controller", this.getClass().getInterfaces());
        FileOutputStream fos = new FileOutputStream(new File("D:\\$Controller.class"));
        fos.write(bts);
        fos.flush();
        fos.close();
        UserInfo info = get(id);
        int a = 10/t;

        return BaseResult.success("更新用户成功",info);
    }


    @DataSource(DBType.OTHER)
    @Transactional(transactionManager = "otherTransactionManager")
    public void update1(Long id){
        otherUserInfoMapper.updateUserInfo(id,"other");
    }

    @DataSource(DBType.MASTER)
    @Transactional(transactionManager = "masterTransactionManager")
    public void update2(Long id){
        otherUserInfoMapper.updateUserInfo(id,"master");
    }


    @DataSource(DBType.OTHER)
    @Transactional(transactionManager = "otherTransactionManager")
    public UserInfo get(Long id){
        return otherUserInfoMapper.getUserInfoById(id);
    }



    //@Transactional(transactionManager = "otherTransactionManager")
    //@DataSource(DBType.OTHER)
    @RequestMapping("/updateUser2/{id}/{username}/{t}")
    @ResponseBody
    public BaseResult updateUser2(@PathVariable("id") Long id,@PathVariable("username")String username,@PathVariable("t")Integer t){
        update1(1L);
        UserInfo info = get(id);
        int a = 10/t;
        return BaseResult.success("updateUser2 更新用户成功",info);
    }


}
