package com.xjj.java.designpattern.factory.absfactory.order;

import com.sun.org.apache.xpath.internal.operations.Or;

/**
 * @description:
 * @author: xujianjie
 * @create: 2020-07-19 11:13
 **/
public class PizzaStore {

    public static void main(String[] args) {
        new OrderPizza(new BJFactory());
    }

}
