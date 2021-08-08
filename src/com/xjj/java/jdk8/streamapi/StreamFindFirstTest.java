package com.xjj.java.jdk8.streamapi;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @description:
 * @author: xujianjie
 * @create: 2021-07-25 16:14
 **/
public class StreamFindFirstTest {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("aa","bb","cc");
        Optional<String> first = list.stream().findFirst();
        System.out.println(first.get());

        List<String> list2 = Arrays.asList("aa","bb","cc");
        Optional<String>  any = list.stream().findAny();
        System.out.println(any.get());
    }

}
