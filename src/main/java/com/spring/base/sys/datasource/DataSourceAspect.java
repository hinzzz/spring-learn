package com.spring.base.sys.datasource;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author ：quanhz
 * @date ：Created in 2019/9/18 15:49
 */
@Aspect
@Component
public class DataSourceAspect {

    private final static Logger log = LoggerFactory.getLogger(DataSourceAspect.class);

    @Pointcut("@annotation(com.spring.base.sys.datasource.DataSource)")
    public void determineDataSource() {

    }


    @Before("determineDataSource()")
    public void getDataSource(JoinPoint joinPoint) {
        /*
         * 1、获取类名
         * 2、获取切到方法名
         * 3、获取注解上的参数
         */
        Class<?> aClass = joinPoint.getTarget().getClass();


        Class<?>[] parameterTypes = ((MethodSignature) joinPoint.getSignature()).getParameterTypes();
        String methodName = joinPoint.getSignature().getName();
        System.out.println("methodName = " + methodName);
        try {
            Method method = aClass.getMethod(methodName, parameterTypes);
            DataSource dataSource = method.getAnnotation(DataSource.class);
            log.info("当前数据库：" + dataSource.value());
            DynamicDataSourceHolder.put(dataSource.value());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    @After("determineDataSource()")
    public void clearDataSource() {
        log.info("重置数据库。。。。。。。。。");
        DynamicDataSourceHolder.clear();
    }

}
