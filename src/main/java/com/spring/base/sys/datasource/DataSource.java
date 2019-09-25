package com.spring.base.sys.datasource;

import org.springframework.stereotype.Repository;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 数据源的注解，用来选择主从库
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Repository
public @interface DataSource {

    String value() default "master";

}
