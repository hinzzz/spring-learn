package com.spring.sys.datasource;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author ：quanhz
 * @date ：Created in 2019/9/18 15:49
 */
@Aspect
@Component
public class DataSourceAspect {

    @Pointcut("@annotation(com.spring.sys.datasource.DataSource)")
    public void determineDataSource(){

    }


    @Before("determineDataSource()")
    public void getDataSource(JoinPoint joinPoint){
        /*
         * 1、获取类名
         * 2、获取切到方法名
         * 3、获取注解上的参数
         */
        Class<?> aClass = joinPoint.getTarget().getClass();


        Class<?>[] parameterTypes = ((MethodSignature)joinPoint.getSignature()).getParameterTypes();
        String methodName = joinPoint.getSignature().getName();
        try {
            Method method = aClass.getMethod(methodName, parameterTypes);
            DataSource dataSource = method.getAnnotation(DataSource.class);
            System.out.println("当前数据库：" + dataSource.value());
            DynamicDataSourceHolder.put(dataSource.value());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    @After("determineDataSource()")
    public void clearDataSource(){
        System.out.println("重置数据库...........");
        DynamicDataSourceHolder.clear();
    }

}
