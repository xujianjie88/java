package com.xjj.java.jdk8.predicate;

import java.util.function.Predicate;

/**
 * @description:
 * @author: xujianjie
 * @create: 2021-07-25 10:50
 **/
public class PredicateTest {


    public static void main(String[] args) {
        testPredicate(msg -> {
            return msg.length() > 3;
        },"hello xujianjie");
    }

    /**
     * 使用predicate进行and or 等逻辑判断
     * @param predicate
     * @param msg
     * @return
     */
    private static Boolean testPredicate(Predicate<String> predicate,String msg){
        boolean result = predicate.test(msg);
        System.out.println(result);
        return result;
    }


}
