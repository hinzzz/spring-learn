package com.spring.base.sys.log;

import java.lang.annotation.*;

/**
 * @author ：quanhz
 * @date ：Created in 2019/9/18 9:48
 */

@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SystemLog {
    //方法描述
    String methodDesc() default "";

    //菜单code
    String menuCode() default "";
}
