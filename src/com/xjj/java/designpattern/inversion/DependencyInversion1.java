package com.xjj.java.designpattern.inversion;

/**
 * 依赖倒置原则
 */
public class DependencyInversion1 {

    public static void main(String[] args) {
        Person person = new Person();
        person.receive(new Email());
    }
}
//发送邮件
class Email{
    public String getInfo(){
        return "电子邮件信息";
    }
}

//接收消息
//方式一分析
//1.简单，比较容易得到
//2.如果我们获取的对象是微信，短信等等，则新增类，同时Person也要新加接受方法
//3.解决思路：引入一个抽象类的接口IReceiver,表示接收者，这Person类与接口IReceiver发生依赖
//因为Email,WeiXin等等属于接收范围，他们各自实现IReceiver接口就ok,这样我们就符合依赖倒置原则的思想
class Person{
    public void receive(Email email){
        System.out.println(email.getInfo());
    }
}