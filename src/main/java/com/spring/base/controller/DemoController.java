package com.spring.base.controller;

import com.spring.base.base.BaseResult;
import com.spring.base.model.UserInfo;
import com.spring.base.service.UserInfoSeveice;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author quanhz
 */
@Controller
public class DemoController {

    @Resource
    private UserInfoSeveice userInfoSeveice;


    @RequestMapping("/update/{id}")
    @ResponseBody
    public BaseResult updateUserInfo(@PathVariable("id")Long id){
        userInfoSeveice.updateUserInfo(id);
        return BaseResult.success("修改成功");
    }


    @GetMapping("/one/{err}")
    @ResponseBody
    public BaseResult testError(@PathVariable("err") String err ) {
        UserInfo info = userInfoSeveice.getUserInfoById(err);

        return BaseResult.success("操作成功",info);
    }


}