package com.xjj.java.designpattern.adapter.classadapter;

public class Client {

    public static void main(String[] args) {
        Phone phone = new Phone();
        phone.charging(new VoltageAdapter());
    }
}
