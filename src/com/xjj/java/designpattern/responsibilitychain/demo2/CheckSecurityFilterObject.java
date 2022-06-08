package com.xjj.java.designpattern.responsibilitychain.demo2;

import com.xjj.java.designpattern.responsibilitychain.demo2.dto.Request;
import com.xjj.java.designpattern.responsibilitychain.demo2.dto.Response;

/**
 *  ��ȫУ�����
 */
//@Component
//@Order(2) //У��˳���ŵ�2
public class CheckSecurityFilterObject extends AbstractHandler {

    @Override
    public void doFilter(Request request, Response response) {
        //invoke Security check
        System.out.println("��ȫ����У��");
    }
}

