package com.xjj.java.collection;

import java.util.HashMap;
import java.util.Map;

/**
 *  怎么确保一个集合不能被修改？
 *
 *  很多朋友很可能想到用final关键字进行修饰，final修饰的这个成员变量，如果是基本数据类型，表示这个变量的值是不可改变的，
 *  如果是引用类型，则表示这个引用的地址值是不能改变的，但是这个引用所指向的对象里面的内容还是可以改变滴~验证一下，
 */
public class ModifyCollection {

    //final 修饰
    private static final Map<Integer, String> map = new HashMap<Integer, String>();
    {
        map.put(1, "jay");
        map.put(2, "tianluo");
    }

    public static void main(String[] args) {
        map.put(1, "boy");
        System.out.println(map.get(1));
    }

}
