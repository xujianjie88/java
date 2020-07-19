package com.xjj.java.operator;

/**
 * @description: 测试i++、++i,i--,--i
 * @author: xujianjie
 * @create: 2020-07-05 14:44
 **/
public class AutoInc {

    public static void main(String[] args) {
        int i = 1;
        System.out.println("i: " + i);//1
        System.out.println("++i: " + ++i); // 前递增 2
        System.out.println("i++: " + i++); // 后递增 2
        System.out.println("i: " + i); // 3
        System.out.println("--i: " + --i); // 前递减 2
        System.out.println("i--: " + i--); // 后递减 3
        System.out.println("i: " + i);//1
    }

}
