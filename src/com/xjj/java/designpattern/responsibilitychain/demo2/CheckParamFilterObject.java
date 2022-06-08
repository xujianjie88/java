package com.xjj.java.designpattern.responsibilitychain.demo2;

import com.xjj.java.designpattern.responsibilitychain.demo2.AbstractHandler;
import com.xjj.java.designpattern.responsibilitychain.demo2.dto.Request;
import com.xjj.java.designpattern.responsibilitychain.demo2.dto.Response;

/**
 * ����У�����
 **/
//@Component
//@Order(1) //˳���ŵ�1������У��
public class CheckParamFilterObject extends AbstractHandler {

    @Override
    public void doFilter(Request request, Response response) {
        System.out.println("�ǿղ������");
    }
}
