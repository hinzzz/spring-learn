package com.spring.base.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @author quanhz
 */
@Controller
public class LoginController {






    @RequestMapping(value = "/login",method = RequestMethod.GET )
    public String login(@RequestBody List<Map<String, String>> list)throws Exception{
        //登陆成功
        /*if(userInfo.getUsername().equals("1") && userInfo.getPassword().equals("1")){
            String token = UUID.randomUUID().toString();
            session.setAttribute(token,userInfo);
            session.setMaxInactiveInterval(30);
            Cookie cookie = new Cookie("user_info",token);
            response.addCookie(cookie);
        }*/
        return "redirect:/main.html";
    }

    @RequestMapping("toLogin")
    public String toLogin(){
        return "index";
    }


    @ResponseBody
    @RequestMapping("hello")
    public String hello(){
        return "aaa";
    }
}

