package com.xjj.java.designpattern.factory.absfactory.order;

import com.xjj.java.designpattern.factory.absfactory.pizza.Pizza;

/**
 * @description:一个抽象接口模式的抽象层
 * @author: xujianjie
 * @create: 2020-07-19 11:02
 **/
public interface AbsFactory {

    //让下面的工厂子类自己实现
    Pizza CreatePizza(String orderType);
}
