package com.xjj.java.designpattern.handler2.annotation;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FetchInvoiceTypeAnnotation {
    String value() default "";
}
