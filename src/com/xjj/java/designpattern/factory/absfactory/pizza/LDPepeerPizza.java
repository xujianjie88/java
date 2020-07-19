package com.xjj.java.designpattern.factory.absfactory.pizza;

/**
 * @description:
 * @author: xujianjie
 * @create: 2020-07-19 10:37
 **/
public class LDPepeerPizza extends Pizza {

    @Override
    public void prepare() {
        setName("伦敦的胡椒 pizza");
        System.out.println("伦敦的胡椒披萨准备原材料");
    }
}
