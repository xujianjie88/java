package com.xjj.java.annotation;

import java.lang.annotation.*;

@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Check {

    boolean login() default true;

    boolean sign() default false;

}
