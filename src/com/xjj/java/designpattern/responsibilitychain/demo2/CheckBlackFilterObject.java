package com.xjj.java.designpattern.responsibilitychain.demo2;

import com.xjj.java.designpattern.responsibilitychain.demo2.dto.Request;
import com.xjj.java.designpattern.responsibilitychain.demo2.dto.Response;
/**
 *  ������У�����
 */
//@Component
//@Order(3) //У��˳���ŵ�3
public class CheckBlackFilterObject extends AbstractHandler{

    @Override
    public void doFilter(Request request, Response response) {
        //invoke black list check
        System.out.println("У�������");
    }

}
