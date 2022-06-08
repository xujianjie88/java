package com.xjj.java.designpattern.responsibilitychain.demo2;

import com.xjj.java.designpattern.responsibilitychain.demo2.dto.Request;
import com.xjj.java.designpattern.responsibilitychain.demo2.dto.Response;

/**
 *  �������ض���
 */
//@Component
//@Order(4) //У��˳���ŵ�4
public class CheckRuleFilterObject extends AbstractHandler{

    @Override
    public void doFilter(Request request, Response response) {
        //check rule
        System.out.println("check rule");
    }

}
