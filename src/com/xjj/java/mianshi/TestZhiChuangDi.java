package com.xjj.java.mianshi;

public class TestZhiChuangDi {


    public static void main(String[] args) {
        Integer var1 = new Integer(1);
        Integer var2 = var1;
        doSomething(var2);
        System.out.println(var1.intValue());
        System.out.println(var1 == var2);
    }

    private static void doSomething(Integer integer) {
        integer = new Integer(2);
    }


}
