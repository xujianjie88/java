package com.xjj.java.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * 要求创建cat对象并执行其类中eat方法
 */
public class CheckAnnotationTest {
    public static void main(String[] args) throws Exception {
        //获取该类的类对象
        Class<User> userClass = User.class;
        //4、获取类上的所有注解 ?
        Annotation[] classAnnotation = userClass.getAnnotations();
        for (Annotation cAnnotation : classAnnotation) {
            Class annotationType = cAnnotation.annotationType();
            System.out.println("User类上的注解有: " + annotationType);
        }
        //获取方法上的所有注解
//        Annotation[] methodAnnotations = method.getAnnotations();
//        for (Annotation me : methodAnnotations) {
//            Class annotationType = me.annotationType();
//            System.out.println("获取方法上的所有注解: " + annotationType);
//          }
        //获取类方法中的注解对象，得到是否要登录属性
        Method method = userClass.getMethod("findUserInfo", Integer.class);
        Check annotationCheck = method.getAnnotation(Check.class);
        boolean login = annotationCheck.login();
        if (login) {
            //判断用户是否登录，调用当前方法
            System.out.println("用户需要登录");
        } else {
            System.out.println("用户不需要登录");
        }
        User user = userClass.newInstance();
        user.findUserInfo(10);

        //获取签名属性
        boolean sign = annotationCheck.sign();
        System.out.println("需不需要签名：" + sign);

    }
}