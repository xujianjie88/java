package com.xjj.java.operator;

/**
 * @description: 测试关系运算符
 * @author: xujianjie
 * @create: 2020-07-05 14:47
 **/
public class Equivalence {

    public static void main(String[] args) {
        Integer n1 = 47;
        Integer n2 = 47;
        System.out.println(n1 == n2);//true
        System.out.println(n1 != n2);//false

        //比较对象的内容是否相同 你必须使用所有对象（不包括基本类型）中都存在的 equals() 方法
        System.out.println(n1.equals(n2));


    }

}
