package com.xjj.java.designpattern.inversion;

public class DependencyInversion2 {

    public static void main(String[] args) {
        Person person = new Person();
        person.receive(new Email());
        person.receive(new WeiXin());
    }

    interface IReceive{
         String getInfo();
    }

    static class Email implements IReceive{
        public String getInfo() {
            return "电子邮件信息:哈哈，你个大傻瓜";
        }
    }

    static class WeiXin implements IReceive{
        public String getInfo() {
            return "微信消息：哈哈，你个大傻瓜";
        }
    }

    static class Person{
        public void receive(IReceive iReceive){
            System.out.println(iReceive.getInfo());
        }
    }
}
