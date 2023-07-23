package com.xjj.java.designpattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 登录之后，发送短信和邮箱通知
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
