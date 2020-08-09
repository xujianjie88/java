package com.xjj.java.mianshi;

/**
 * @description:
 * @author: xujianjie
 * @create: 2020-08-04 21:25
 **/
public class Test {

    public static void main(String[] args) {
        int x = 1;
        int y = x>>1;
        System.out.println(x);
        System.out.println(y);

        String s1 = "hello world";
        String s2 = new String(s1);
        if(s1==s2){
            System.out.println("A");
        }
        if(s1.equals(s2)){
            System.out.println("B");
        }

    }

}
