package com.xjj.java.designpattern.observer;

public class EmailObserver implements Observer{

    @Override
    public void sendMessage(String msg) {
        System.out.println("EmailObserver receiver msg:"+msg);
    }
}
