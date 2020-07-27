package com.xjj.java.designpattern.adapter.objectadapter;

public class Client {

    public static void main(String[] args) {
        System.out.println("¶ÔÏóÊÊÅäÆ÷");
        Phone phone = new Phone();
        phone.charging(new VoltageAdapter(new Voltage220V()));
    }
}
