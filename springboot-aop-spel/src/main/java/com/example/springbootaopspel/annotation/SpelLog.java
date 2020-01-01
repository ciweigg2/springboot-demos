package com.example.springbootaopspel.annotation;

import java.lang.annotation.*;

/**
 * @author maxiucheng
 * @className SpelLog
 * @description
 * @date 2020/1/1 12:20 下午
 * @menu
 **/
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Target(ElementType.METHOD)
public @interface SpelLog {

    String value() default "";

}
