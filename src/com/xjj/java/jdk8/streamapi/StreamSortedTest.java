package com.xjj.java.jdk8.streamapi;

import java.util.Arrays;
import java.util.List;

/**
 * @description:
 * @author: xujianjie
 * @create: 2021-07-25 15:12
 **/
public class StreamSortedTest {

    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(3,1,2,4);
        integerList.stream()
//                //µ¹Ðò
//                .sorted((o1,o2)->o2-o1)
                //ÉýÐò
                .sorted((o1,o2)->o1-o2)
                .forEach(System.out::println);
    }

}
