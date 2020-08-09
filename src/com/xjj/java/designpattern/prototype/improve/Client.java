package com.xjj.java.designpattern.prototype.improve;

/**
 * @description:
 * @author: xujianjie
 * @create: 2020-07-19 14:38
 **/
public class Client {

    public static void main(String[] args) {
        System.out.println("使用原型模式克隆羊");
        Sheep sheep = new Sheep("tom", 11, "白色");
        Sheep sheep1 = (Sheep) sheep.clone();//克隆
        Sheep sheep2 = (Sheep) sheep.clone();
        Sheep sheep3 = (Sheep) sheep.clone();
        Sheep sheep4 = (Sheep) sheep.clone();
        Sheep sheep5 = (Sheep) sheep.clone();

        System.out.println(sheep);
        System.out.println(sheep1);
        System.out.println(sheep2);
        System.out.println(sheep3);
        System.out.println(sheep4);
        System.out.println(sheep5);
    }

}
