package com.xjj.java.jdk8.streamapi;

import java.util.stream.Stream;

/**
 * @description:
 * @author: xujianjie
 * @create: 2021-07-25 16:26
 **/
public class StreamReduceTest {


    public static void main(String[] args) {
        //对数据进行运算
        Integer sum = Stream.of(3, 5, 4, 8).reduce(0, (x, y) -> x + y);
        System.out.println(sum);
    }

}
