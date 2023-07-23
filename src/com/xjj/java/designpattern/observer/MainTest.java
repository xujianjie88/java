package com.xjj.java.designpattern.observer;

public class MainTest {
    /**
     * 登录成功，同时发送邮件和短信信息
     * @param args
     */
    public static void main(String[] args) {
        LoginSubject loginSubject = new LoginSubject();
        // 添加观察者
        loginSubject.addObserver(new EmailObserver());
        loginSubject.addObserver(new MessageObserver());
        // 执行登录逻辑
        loginSubject.login("zhansan is execute Login,please check is your device");
    }
}
