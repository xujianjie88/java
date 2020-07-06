package com.xjj.java.operator;

/**
 * 带符号右移运算符用“>>”表示，是将运算符左边的运算对象，向右移动运算符右边指定的位数。如果是正数，在高位补零，如果是负数，则在高位补1
 */
public class TestNumMoveRight {

    public static void main(String[] args) {
        int a=16;
        int c=-16;
        int b=2;
        int d=2;
        System.out.println("a 的移位结果："+(a>>b));
        System.out.println("c 的移位结果："+(c>>d));
        //结果分析：
        //a 的值是16转换成二进制是00010000，让它右移两位成00000100 即4，c 的值是-16转换成二进制是11101111，让它右移一位成11111011 即-4
    }
}
