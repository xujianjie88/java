package com.xjj.java.jdk8.streamapi;

import java.util.Arrays;
import java.util.List;

/**
 * @description:
 * @author: xujianjie
 * @create: 2021-07-25 11:47
 **/
public class StreamCountTest {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("aa","bb","cc");
        long count = list.stream().count();
        System.out.println(count);
    }

}
