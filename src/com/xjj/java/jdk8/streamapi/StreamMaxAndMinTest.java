package com.xjj.java.jdk8.streamapi;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @description:
 * @author: xujianjie
 * @create: 2021-07-25 16:22
 **/
public class StreamMaxAndMinTest {

    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("1","2","3");
        Optional<Integer> max = stringList.stream()
                .map(Integer::parseInt)
                .max((o1, o2) -> o1 - o2);
        System.out.println(max.get());

        Optional<Integer> min = stringList.stream()
                .map(Integer::parseInt)
                .min((o1, o2) -> o1 - o2);
        System.out.println(min.get());
    }

}
