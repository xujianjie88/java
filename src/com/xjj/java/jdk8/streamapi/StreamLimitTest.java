package com.xjj.java.jdk8.streamapi;

import java.util.Arrays;
import java.util.List;

/**
 * @description:
 * @author: xujianjie
 * @create: 2021-07-25 14:57
 **/
public class StreamLimitTest {

    public static void main(String[] args) {
        //ֻȡ����ǰ����ٸ�Ԫ��
        List<String> list = Arrays.asList("aa","bb","cc");
        list.stream().limit(2).forEach(System.out::println);
    }

}
