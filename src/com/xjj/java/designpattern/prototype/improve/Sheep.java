package com.xjj.java.designpattern.prototype.improve;

/**
 * @description:浅拷贝
 * @author: xujianjie
 * @create: 2020-07-19 14:24
 **/
public class Sheep implements Cloneable{

    private String name;

    private int age;

    private String color;

    private String address = "内蒙古";

    public Sheep(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Sheep{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    //克隆该实例，使用默认的方法来完成
    @Override
    protected Object clone(){
        Sheep sheep = null;
        try {
            sheep = (Sheep)super.clone();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return sheep;
    }
}
