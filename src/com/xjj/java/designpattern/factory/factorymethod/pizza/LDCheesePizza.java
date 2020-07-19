package com.xjj.java.designpattern.factory.factorymethod.pizza;

/**
 * @description:
 * @author: xujianjie
 * @create: 2020-07-19 10:35
 **/
public class LDCheesePizza extends Pizza {

    @Override
    public void prepare() {
        setName("伦敦的奶酪pizza");
        System.out.println("伦敦的奶酪披萨准备原材料");
    }
}
