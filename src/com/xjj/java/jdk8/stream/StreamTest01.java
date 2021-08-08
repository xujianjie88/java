package com.xjj.java.jdk8.stream;

import java.util.Arrays;
import java.util.List;

/**
 * @description:
 * @author: xujianjie
 * @create: 2021-07-25 11:07
 **/
public class StreamTest01 {


    public static void main(String[] args) {
        List<String> list = Arrays.asList("����","������","����","����");
        //��� ���ŵ� �� ���Ƴ��ȴ���3���û���Ϣ
        list.stream()
                .filter(s->s.startsWith("��"))
                .filter(s->s.length()>3)
                .forEach(System.out::println);
    }

}
