package com.spring.base.sys.datasource;

import org.springframework.stereotype.Repository;

import java.lang.annotation.*;

/**
 * 数据源的注解，用来选择主从库
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Repository
@Inherited
public @interface DataSource {

    String value() default "";

}
