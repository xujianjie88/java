package com.xjj.java.jdk8.streamapi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @description:
 * @author: xujianjie
 * @create: 2021-07-25 15:04
 **/
public class StreamMapTest {

    public static void main(String[] args) {
        //��String ���ͼ���ת��Ϊ���μ���
        List<String> stringList = Arrays.asList("1","2","3");
        List<Integer> integerList = stringList.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

}
