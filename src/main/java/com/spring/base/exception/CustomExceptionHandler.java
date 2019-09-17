package com.spring.base.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

/**
 * @author quanhz
 */
@ControllerAdvice
public class CustomExceptionHandler {

    /**
     * 捕获自定义
     * @param e
     * @return json格式类型
     */
    @ResponseBody
    @ExceptionHandler({UserInfoException.class,UnKnowException.class}) //指定拦截异常的类型
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR) //自定义浏览器返回状态码
    public Map<String, Object> customExceptionHandler(Exception e) {
        Map<String, Object> map = new HashMap<>();
        map.put("msg", e.getLocalizedMessage());
        map.put("status",false);
        return map;
    }

    /**
     * 捕获自定义
     * @param e
     * @return json格式类型
     */
    @ResponseBody
    @ExceptionHandler({TransactionException.class}) //指定拦截异常的类型
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR) //自定义浏览器返回状态码
    public Map<String, Object> transactionExceptionHandler(Exception e) {
        Map<String, Object> map = new HashMap<>();
        map.put("msg", e.getLocalizedMessage());
        map.put("status",false);
        return map;
    }
}
