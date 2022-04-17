package com.xjj.java.designpattern.prototype.deepclone;

/**
 * @description:
 * @author: xujianjie
 * @create: 2020-07-19 15:03
 **/
public class Client {

    public static void main(String[] args) throws Exception {
        DeepPrototype deepPrototype = new DeepPrototype();
        deepPrototype.name = "宋江";
        deepPrototype.deepCloneTarget = new DeepCloneTarget("大牛","大牛的类");

//        // 方式一完成深拷贝
//        DeepPrototype deepPrototype2 = (DeepPrototype) deepPrototype.clone();
//        System.out.println("deepPrototype.name"+deepPrototype.name+"deepPrototype.deepCloneTarget="+deepPrototype.deepCloneTarget.hashCode());
//        System.out.println("deepPrototype2.name"+deepPrototype2.name+"deepPrototype2.deepCloneTarget="+deepPrototype2.deepCloneTarget.hashCode());

        // 方式二，对象序列化完成深拷贝
        // 方式一完成深拷贝
        DeepPrototype deepPrototype2 = (DeepPrototype) deepPrototype.clone();
        System.out.println("deepPrototype.name"+deepPrototype.name+"deepPrototype.deepCloneTarget="+deepPrototype.deepCloneTarget.hashCode());
        System.out.println("deepPrototype2.name"+deepPrototype2.name+"deepPrototype2.deepCloneTarget="+deepPrototype2.deepCloneTarget.hashCode());


    }

}
