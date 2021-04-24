package com.xjj.java.designpattern.strategy.pay.service;

import com.xjj.java.designpattern.strategy.vo.OrderVO;

/**
 * @description:
 * @author: xujianjie
 * @create: 2021-04-24 22:48
 **/
public interface Pay {

    boolean pay(OrderVO order);

}
