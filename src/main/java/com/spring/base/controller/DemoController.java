package com.spring.base.controller;

import com.spring.base.base.BaseResult;
import com.spring.base.model.UserInfo;
import com.spring.base.service.UserInfoSeveice;
import com.spring.base.sys.datasource.DBType;
import com.spring.base.sys.datasource.DBTypeEnum;
import com.spring.base.sys.log.LogTest;
import com.spring.base.sys.log.SystemLog;
import com.spring.base.sys.datasource.DataSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * @author quanhz
 */
@Controller
public class DemoController {

    @Resource
    private UserInfoSeveice userInfoSeveice;


    @RequestMapping("/setSession")
    @ResponseBody
    public String setSession(HttpSession session) {
        session.setAttribute("name", "hinzzz");
        return "hello";
    }

    @RequestMapping("/getSession")
    @ResponseBody
    public Object getSession(HttpSession session) {
        return session.getAttribute("name");
    }

    /***
     * 注解@RequestBody接收的参数是来自requestBody中，即请求体。
     * 一般用于处理非 Content-Type: application/x-www-form-urlencoded编码格式的数据，
     * 比如：application/json、application/xml等类型的数据。
     * @param data
     * @return
     */
    @RequestMapping("/testRequestBody")
    @ResponseBody
    public BaseResult testRequestBody(@RequestBody UserInfo data) {
        System.out.println("data.getUsername() = " + data.getUsername());
        System.out.println("data.getPassword() = " + data.getPassword());
        return BaseResult.success("aaa", data);
    }


    @DataSource(DBType.SLAVE)
    @RequestMapping("/updateMaster/{id}")
    @ResponseBody
    public BaseResult updateUserInfo(@PathVariable("id") Long id) {
        userInfoSeveice.updateUserInfo(id);
        return BaseResult.success("修改成功");
    }


    @DataSource(DBType.SLAVE)
    @RequestMapping("/updateSlave/{id}")
    @ResponseBody
    public BaseResult updateSlave(@PathVariable("id") Long id) {
        userInfoSeveice.updateUserInfo(id);
        return BaseResult.success("修改成功");
    }


    @SystemLog(menuCode = "asd.cc", methodDesc = "测试1")
    @GetMapping("/one/{err}")
    @ResponseBody
    public BaseResult testError(@PathVariable("err") String err) {
        UserInfo info = userInfoSeveice.getUserInfoById(err);

        return BaseResult.success("操作成功", info);
    }

    @SystemLog(menuCode = "sys.getLogs", methodDesc = "获取日志")
    @GetMapping("/log")
    @ResponseBody
    public BaseResult getLog() {
        return BaseResult.success("操作成功！", LogTest.getLogs());
    }


    @SystemLog(menuCode = "sys.testMaster", methodDesc = "测试主库")
    @DataSource("master")
    @GetMapping("/master/{err}")
    @ResponseBody
    public BaseResult master(@PathVariable("err") String err) {
        return BaseResult.success("操作成功！", userInfoSeveice.getUserInfoById(err));
    }


    @SystemLog(menuCode = "sys.testMaster", methodDesc = "测试从库")
    @DataSource("slave")
    @GetMapping("/slave/{err}")
    @ResponseBody
    public BaseResult slave(@PathVariable("err") String err) {
        return BaseResult.success("操作成功！", userInfoSeveice.getUserInfoById(err));
    }

}