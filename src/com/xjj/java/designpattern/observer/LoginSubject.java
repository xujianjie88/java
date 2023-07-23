package com.xjj.java.designpattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * ��¼֮�󣬷��Ͷ��ź�����֪ͨ
 */
public class LoginSubject implements Subject{

    private List<Observer> observerList = new ArrayList<>();
    private String msg;

    @Override
    public void addObserver(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observerList.remove(observer);
    }

    public void login(String msg){
        System.out.println("execute login logic");
        this.msg = msg;
        notifyObserver();
    }

    @Override
    public void notifyObserver() {
        for (Observer observer : observerList) {
            observer.sendMessage(msg);
        }
    }
}
