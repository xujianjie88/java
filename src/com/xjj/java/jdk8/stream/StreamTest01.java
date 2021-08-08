package com.xjj.java.jdk8.stream;

import java.util.Arrays;
import java.util.List;

/**
 * @description:
 * @author: xujianjie
 * @create: 2021-07-25 11:07
 **/
public class StreamTest01 {


    public static void main(String[] args) {
        List<String> list = Arrays.asList("张三","张三丰","李四","王五");
        //输出 姓张的 且 名称长度大于3的用户信息
        list.stream()
                .filter(s->s.startsWith("张"))
                .filter(s->s.length()>3)
                .forEach(System.out::println);
    }

}
