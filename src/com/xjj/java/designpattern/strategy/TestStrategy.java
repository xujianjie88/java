package com.xjj.java.designpattern.strategy;

import com.xjj.java.designpattern.strategy.pay.service.impl.AliPay;
import com.xjj.java.designpattern.strategy.pay.service.impl.WeChatPay;
import com.xjj.java.designpattern.strategy.vo.OrderVO;

/**
 * @description: ²âÊÔ²ßÂÔÄ£Ê½
 * @author: xujianjie
 * @create: 2021-04-24 23:03
 **/
public class TestStrategy {

    public static void main(String[] args) {
        PayContext payContext = new PayContext(new WeChatPay());
        payContext.pay(new OrderVO());
    }

}
