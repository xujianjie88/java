package com.xjj.java.designpattern.responsibilitychain.test;

import com.xjj.java.designpattern.responsibilitychain.demo1.*;

public class HandlerChainDemo1Test {

    public static void main(String[] args) {
        PurchaseRequest purchaseRequest = new PurchaseRequest(1, 15000, 1);

        DepartmentHandler departmentHandler = new DepartmentHandler("������");
        CollegeHandler collegeHandler = new CollegeHandler("��Ժ��");
        ViceSchoolMasterHandler viceSchoolMasterHandler = new ViceSchoolMasterHandler("����У��");
        SchoolMasterHandler schoolMasterHandler = new SchoolMasterHandler("��У��");

        // ���ø��������ڵ�(�γ���״�ṹ)
        departmentHandler.setHandler(collegeHandler);
        collegeHandler.setHandler(viceSchoolMasterHandler);
        viceSchoolMasterHandler.setHandler(schoolMasterHandler);
        schoolMasterHandler.setHandler(departmentHandler);

        departmentHandler.processRequest(purchaseRequest);
//        collegeHandler.processRequest(purchaseRequest);
    }
}
