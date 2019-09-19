package com.spring.sys.log;

import com.alibaba.fastjson.JSON;
import com.spring.base.base.BaseResult;
import com.spring.base.model.UserInfo;
import com.spring.base.util.MyRequestUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Random;

/**
 * @author ：quanhz
 * @date ：Created in 2019/9/17 17:49
 */
@Aspect
@Component
public class SystemLogAOP {

    @Pointcut(value = "@annotation(com.spring.sys.log.SystemLog)")
    public void controllerLogAspect(){

    }

    @AfterReturning(pointcut = "controllerLogAspect()",returning = "result")
    public void afterReturn(JoinPoint joinPoint ,Object result){
        if(!(result instanceof BaseResult)){
            return;
        }
        BaseResult baseResult = (BaseResult)result;
        HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
        final UserInfo userInfo = getUserInfo();
        BaseOperLog bLog = new BaseOperLog();
        bLog.setUserName(userInfo.getUsername());
        String[] logDesc = getControllerMethodDesc(joinPoint);
        if(logDesc!=null && logDesc.length==2){
            bLog.setMethodDesc(logDesc[0]);
            bLog.setMenuCode(logDesc[1]);
        }else{
            //若方法上没有加日志注解 获取请求路径
            StringBuilder sb = new StringBuilder();
            String ctx = request.getContextPath();
            String uri = request.getRequestURI().replace(ctx,"");
            System.out.println("ctx = " + ctx);
            System.out.println("uri = " + uri);

            if(uri.indexOf("/")>-1){
                String[] names = uri.split("/");
                for (String name : names) {
                    sb.append(name).append(".");
                }
                sb.setLength(sb.length()-1);
                bLog.setMenuCode(sb.toString());
            }
        }
        bLog.setRequestIp(MyRequestUtil.getRemoteAddr(request));
        bLog.setRequestStatus(baseResult.getStatus()?1:0);
        bLog.setRequestMethod(joinPoint.getTarget().getClass().getName()+"."+joinPoint.getSignature().getName()+"()");
        bLog.setRequestParams(MyRequestUtil.getRequestParams(joinPoint));
        bLog.setReturnResult(JSON.toJSONString(baseResult));
        bLog.setRequestTime(new Date());
        bLog.setId(new Random().nextLong());
        System.out.println("bLog = " + bLog);
        LogTest.put(bLog);
    }

    /***
     * 获取日志注解的描述信息
     * @param joinPoint
     * @return
     */
    private String[] getControllerMethodDesc(JoinPoint joinPoint) {
        String[] result = new String[2];
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        try {
            Class<?> aClass = Class.forName(className);
            Method[] methods = aClass.getMethods();
            for (Method method : methods) {
                //判断方法名是否相同
                if(method.getName().equals(methodName)){
                    //判断参数个数是否一样 因为有可能是方法重载
                    Class<?>[] parameterTypes = method.getParameterTypes();
                    if(parameterTypes.length==args.length){
                        result[0] = method.getAnnotation(SystemLog.class).methodDesc();
                        result[1] = method.getAnnotation(SystemLog.class).menuCode();
                    }
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }

    /***
     * 登陆之后获取用户信息 未实现
     * @return
     */
    private UserInfo getUserInfo() {
        //TODO
        UserInfo userInfo  = new UserInfo();
        userInfo.setUsername("hinzzz");
        userInfo.setPassword("123456");
        return userInfo;
    }

}
