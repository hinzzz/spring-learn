package com.spring.base.util;

import org.aspectj.lang.JoinPoint;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * @author ：quanhz
 * @date ：Created in 2019/9/18 10:47
 */
public class MyRequestUtil {

    public static String getRemoteAddr(HttpServletRequest request) {
        try {
            String xforwardedFor = request.getHeader("x-forwarded-for");
            String xRealIp = request.getHeader("X-Real-IP");
            if (!StringUtils.isEmpty(xforwardedFor)) {
                return xforwardedFor.split(",")[0];
            }
            if (!StringUtils.isEmpty(xRealIp)) {
                return xRealIp;
            }
            return request.getRemoteAddr();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String getRequestParams(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        StringBuilder sb = new StringBuilder();
        if (args != null && args.length > 0) {
            for (Object arg : args) {
                sb.append(arg).append(",");
            }
            sb.setLength(sb.length() - 1);
        }
        return sb.toString();
    }
}
