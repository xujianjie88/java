package com.xjj.java.collection;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Collection.sort是对list进行排序，Arrays.sort是对数组进行排序。
 *         Collections.sort底层实现
 *         Collections.sort方法调用了list.sort方法
 *         list.sort方法调用了Arrays.sort的方法
 *
 * Arrays的sort方法底层就是：
 * legacyMergeSort(a)，归并排序，
 * ComparableTimSort.sort()：即Timsort排序。
 *
 *
 */
public class TestSort {

    //Collections.sort和Arrays.sort的实现原理
    @Test
    public void test(){
        List<Integer> list = Arrays.asList(1, 2, 56, 4);
        Collections.sort(list);
        list.stream().forEach(System.out::println);
    }

}
