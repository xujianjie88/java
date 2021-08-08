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
            //判断是否有元素对于3
            boolean b = stringList.stream()
                    .map(Integer::parseInt)
                    //有一个元素对于3
//                    .anyMatch(s -> s > 3)
                    //没有一个元素大于3的
                    .noneMatch(s -> s > 3);
                    //所有一个元素对于3
//                    .allMatch(s -> s > 3);
            System.out.println(b);
        }

}
