package com.xjj.java.jdk8.streamapi;

import java.util.Arrays;
import java.util.List;

/**
 * @description:
 * @author: xujianjie
 * @create: 2021-07-25 15:27
 **/
public class StreamMatchTest {

        public static void main(String[] args) {
            List<String> stringList = Arrays.asList("1","2","3");
            //�ж��Ƿ���Ԫ�ض���3
            boolean b = stringList.stream()
                    .map(Integer::parseInt)
                    //��һ��Ԫ�ض���3
//                    .anyMatch(s -> s > 3)
                    //û��һ��Ԫ�ش���3��
                    .noneMatch(s -> s > 3);
                    //����һ��Ԫ�ض���3
//                    .allMatch(s -> s > 3);
            System.out.println(b);
        }

}
