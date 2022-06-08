package com.xjj.java.designpattern.handler;

import java.lang.annotation.*;

/**
 * @Description:
 * @Date:Created in 16:14 2018-07-27
 * @Modified By:
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataResolveType {
    String value() default "";
}
