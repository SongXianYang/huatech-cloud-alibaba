package com.huatech.annotation;

import java.lang.annotation.*;

/**
 * @description: 自定义日志注解
 * @author: SongXY
 * @create: 2021-03-08 09:53
 **/
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log {
    //名称
    String name() default "";
    //id
    String id() default "";

    String operation();
}
