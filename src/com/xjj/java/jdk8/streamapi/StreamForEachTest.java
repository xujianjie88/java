package com.xjj.java.jdk8.streamapi;

import java.util.stream.Stream;

/**
 * @description:
 * @author: xujianjie
 * @create: 2021-07-25 11:42
 **/
public class StreamForEachTest {

    public static void main(String[] args) {
        Stream.of("a1","a2","a3").forEach(System.out::println);
    }

}
