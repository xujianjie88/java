package com.xjj.java.designpattern.factory.simplefactory.pizza;

/**
 * @description:
 * @author: xujianjie
 * @create: 2020-07-18 09:24
 **/
public class CheesePizza extends Pizza {

    @Override
    public void prepare() {
        System.out.println("准备奶酪披萨的原材料");
    }
}
