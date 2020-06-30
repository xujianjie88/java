package com.xjj.java.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class TestListAndArrayExchange {


    @Test
    public void testListToArray() {
        //List 转Array，必须使用集合的 toArray(T[] array)
        List<String> list = new ArrayList<String>();
        list.add("jay");
        list.add("tianluo");

        // 使用泛型，无需显式类型转换
        String[] array = list.toArray(new String[list.size()]);
        System.out.println(array[0]);

       //如果直接使用 toArray 无参方法，返回值只能是 Object[] 类，强转其他类型可能有问题(错误示例)
        List<String> list2 = new ArrayList<String>();
        list2.add("jay");
        list2.add("tianluo");

        String[] array2 = (String[]) list.toArray();
        System.out.println(array2[0]);
    }

    @Test
    public void testArrayToList() {
        List<Integer> integers = Arrays.asList(1,2,3);
        integers.stream().forEach(System.out::println);
    }








}
