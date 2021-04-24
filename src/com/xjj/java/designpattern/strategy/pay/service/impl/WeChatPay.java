package com.xjj.java.designpattern.strategy.pay.service.impl;

import com.xjj.java.designpattern.strategy.pay.service.Pay;
import com.xjj.java.designpattern.strategy.vo.OrderVO;

/**
 * @description: Œ¢–≈÷ß∏∂°¢
 * @author: xujianjie
 * @create: 2021-04-24 22:51
 **/
public class WeChatPay implements Pay {

    @Override
    public boolean pay(OrderVO order) {
        System.out.println("wechat pay ....");
        return true;
    }
}
