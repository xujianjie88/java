package com.xjj.java.jdk8.streamapi;

import java.util.Arrays;
import java.util.List;

/**
 * @description:
 * @author: xujianjie
 * @create: 2021-07-25 15:18
 **/
public class StreamDistinctTest {

    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(3,1,1,4);
        integerList.stream().distinct().forEach(System.out::println);
    }

}
