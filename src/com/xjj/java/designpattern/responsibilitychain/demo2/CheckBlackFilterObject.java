package com.xjj.java.designpattern.responsibilitychain.demo2;

import com.xjj.java.designpattern.responsibilitychain.demo2.dto.Request;
import com.xjj.java.designpattern.responsibilitychain.demo2.dto.Response;
/**
 *  黑名单校验对象
 */
//@Component
//@Order(3) //校验顺序排第3
public class CheckBlackFilterObject extends AbstractHandler{

    @Override
    public void doFilter(Request request, Response response) {
        //invoke black list check
        System.out.println("校验黑名单");
    }

}
