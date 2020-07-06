package com.xjj.java.operator;

/**
 * 右移运算符无符号用“>>>”表示，是将运算符左边的对象向右移动运算符右边指定的位数，
 *  并且在高位补0，其实右移n 位，就相当于除上2 的n 次方
 */
public class TestMoveRight {

    public static void main(String[] args) {
        int a=16;
        int b=2; //16/2^2=4
        System.out.println("a 移位的结果是"+(a>>>b));
    }
}
