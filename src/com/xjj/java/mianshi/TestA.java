package com.xjj.java.mianshi;

public class TestA {

    public static void main(String[] args) {
        int i = 10;
        change(i);
        System.out.println(i);
        Integer integer = change2(i);
        System.out.println(integer);
    }

    public static void change(int i){
        i = 100;
    }

    public static Integer change2(int i){
        i = 100;
        return i;
    }
}
