package com.xjj.java.designpattern.observer;

public class MainTest {
    /**
     * ��¼�ɹ���ͬʱ�����ʼ��Ͷ�����Ϣ
     * @param args
     */
    public static void main(String[] args) {
        LoginSubject loginSubject = new LoginSubject();
        // ��ӹ۲���
        loginSubject.addObserver(new EmailObserver());
        loginSubject.addObserver(new MessageObserver());
        // ִ�е�¼�߼�
        loginSubject.login("zhansan is execute Login,please check is your device");
    }
}
