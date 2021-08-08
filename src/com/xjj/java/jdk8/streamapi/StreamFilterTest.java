package com.xjj.java.jdk8.streamapi;

import java.util.Arrays;
import java.util.List;

/**
 * @description:
 * @author: xujianjie
 * @create: 2021-07-25 14:51
 **/
public class StreamFilterTest {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("aa","bb","cc");
        list.stream()
                .filter(s ->s.startsWith("a"))
                .forEach(System.out::println);
    }

}
