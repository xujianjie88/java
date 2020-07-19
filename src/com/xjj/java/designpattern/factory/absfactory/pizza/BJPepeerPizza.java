package com.xjj.java.designpattern.factory.absfactory.pizza;

/**
 * @description:
 * @author: xujianjie
 * @create: 2020-07-19 10:32
 **/
public class BJPepeerPizza extends Pizza {

    @Override
    public void prepare() {
        setName("北京的胡椒pizza");
        System.out.println("北京的Pepeer披萨准备原材料");
    }
}
