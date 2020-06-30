package com.xjj.java.optional;


import org.junit.Test;

import java.util.Optional;

/**
 * guava的Optional类似于Java 8新增的Optional类，都是用来处理null的，
 * 不过guava的是抽象类，其实现类为Absent和Present，而java.util的是final类。其中一部分方法名是相同的。
 *
 *
 * Guava用Optional表示可能为null的T类型引用。一个Optional实例可能包含非null的引用（我们称之为引用存在），
 * 也可能什么也不包括（称之为引用缺失）。它从不说包含的是null值，而是用存在或缺失来表示。但Optional从不会包含null值引用。
 */
public class OptionalDemo {
    public static void main(String[] args) {
        Integer value1=null;
        Integer value2=10;
       /*创建指定引用的Optional实例，若引用为null则快速失败返回absent()
         absent()创建引用缺失的Optional实例
        */
        Optional<Integer> a= Optional.ofNullable(value1);
        Optional<Integer> b= Optional.of(value2); //返回包含给定的非空引用Optional实例
        System.out.println(sum(a,b));
    }

    private static Integer sum(Optional<Integer> a,Optional<Integer> b){
        //isPresent():如果Optional包含非null的引用（引用存在），返回true
        System.out.println("First param is present: "+a.isPresent());
        System.out.println("Second param is present: "+b.isPresent());
        Integer value1=a.orElse(0);  //返回Optional所包含的引用,若引用缺失,返回指定的值
        Integer value2=b.get(); //返回所包含的实例,它必须存在,通常在调用该方法时会调用isPresent()判断是否为null
        return value1+value2;
    }

    @Test
    public void test(){
        System.out.println(Optional.ofNullable(null).orElse(2));
    }


}

