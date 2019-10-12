package com.spring.base.controller;

import com.spring.base.model.User;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.UUID;

/**
 * @author ：quanhz
 * @date ：Created in 2019/10/10 15:22
 */
@RequestMapping("/rest")
@Controller
public class RestController {

    @RequestMapping("/getUser")
    @ResponseBody
    @Cacheable(value="user-key")
    public User getUser() {
        User user=new User("aa@126.com", 18);
        System.out.println("若下面没出现“无缓存的时候调用”字样且能打印出数据表示测试成功");
        return user;
    }


    @ResponseBody
    @RequestMapping("/uid")
    String uid(HttpSession session) {
        UUID uid = (UUID) session.getAttribute("uid");
        if (uid == null) {
            uid = UUID.randomUUID();
        }
        session.setAttribute("uid", uid);
        return session.getId();
    }

}
