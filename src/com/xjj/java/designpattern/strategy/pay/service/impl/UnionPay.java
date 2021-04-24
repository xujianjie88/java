package com.xjj.java.designpattern.strategy.pay.service.impl;

import com.xjj.java.designpattern.strategy.vo.OrderVO;
import com.xjj.java.designpattern.strategy.pay.service.Pay;

/**
 * @description: ÒøÁªÖ§¸¶
 * @author: xujianjie
 * @create: 2021-04-24 22:51
 **/
public class UnionPay implements Pay {

    @Override
    public boolean pay(OrderVO order) {
        System.out.println("union pay ....");
        return true;
    }
}
