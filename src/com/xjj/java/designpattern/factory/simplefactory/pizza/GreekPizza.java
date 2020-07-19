package com.xjj.java.designpattern.factory.simplefactory.pizza;

/**
 * @description:
 * @author: xujianjie
 * @create: 2020-07-18 09:23
 **/
public class GreekPizza extends Pizza {

    @Override
    public void prepare() {
        System.out.println("准备希腊披萨原材料");
    }
}
