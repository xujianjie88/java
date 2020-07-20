package com.xjj.java.designpattern.singleton.lazy.safe;

/**
 * 懒汉式
 */
public class SynchronizeLazySingleton {

    public static void main(String[] args) {
        Singleton instance1 = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        System.out.println(instance1 == instance2);
    }


}

class Singleton{

    private Singleton(){}

    public static Singleton instance;



    public static synchronized Singleton getInstance(){
        if(instance==null){
            //这线程安全,但是效率低
            instance = new Singleton();
        }
        return instance;
    }


//    public static Singleton getInstance(){
//        if(instance==null){
//            //这种也是线程不安全的
//            synchronized (Singleton.class){
//                instance = new Singleton();
//            }
//        }
//        return instance;
//    }

}

