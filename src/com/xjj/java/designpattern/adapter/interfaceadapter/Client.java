package com.xjj.java.designpattern.adapter.interfaceadapter;

public class Client {

    public static void main(String[] args) {
        AbsAdapter absAdapter = new AbsAdapter() {
            @Override
            public void m1() {
                System.out.println("使用m1的方法");
            }
        };
        absAdapter.m1();
    }
}
