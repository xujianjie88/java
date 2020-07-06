package com.xjj.java.operator;

/**
 *
 *  无符号右移运算符
 *      右移运算符无符号用“>>>”表示，是将运算符左边的对象向右移动运算符右边指定的位数，并且在高位补0，其实右移n 位，就相当于除上2 的n 次方
 *      2的二进制是00000010，它向左移动2 位，就变成了00001000，即8。如果从另一个角度来分析，它向左移动2 位，其实就是乘上2 的2 次方，结果还是8
 */
public class TestMoveLeft {
    public static void main(String[] args) {
        int a=16;
        int b=2;
        System.out.println("a 移位的结果是"+(a>>>b));
    }
}
