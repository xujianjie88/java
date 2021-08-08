package com.xjj.java.jdk8.streamapi;

import java.util.Arrays;
import java.util.List;

/**
 * @description:
 * @author: xujianjie
 * @create: 2021-07-25 15:00
 **/
public class StreamSkipTest {

    public static void main(String[] args) {
        //½ØÈ¡ÔªËØ
        List<String> list = Arrays.asList("aa","bb","cc");
        list.stream().skip(2).forEach(System.out::println);
    }

}
