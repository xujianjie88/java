package com.xjj.java.designpattern.factory.absfactory.pizza;

/**
 * @description:北京奶酪披萨
 * @author: xujianjie
 * @create: 2020-07-19 10:31
 **/
public class BJCheesePizza extends Pizza {

    @Override
    public void prepare() {
        setName("北京的奶酪pizza");
        System.out.println("北京的奶酪披萨准备原材料");
    }
}
