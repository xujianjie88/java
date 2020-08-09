package com.xjj.java.designpattern.singleton.lazy.unsafe;


/**
 * 懒汉式，线程不安全
 */
public class LazySingletonTest {


    public static void main(String[] args) {
        Singleton instance1 = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        System.out.println(instance1 == instance2);
    }
}


class Singleton{

    private Singleton(){}

    public static Singleton instance = null;

    public static Singleton getInstance(){
        if(instance==null){
            instance = new Singleton();
        }
        return instance;
    }
}


