package com.xjj.java.designpattern.responsibilitychain.test;

import com.xjj.java.designpattern.responsibilitychain.demo1.*;

public class HandlerChainDemo1Test {

    public static void main(String[] args) {
        PurchaseRequest purchaseRequest = new PurchaseRequest(1, 15000, 1);

        DepartmentHandler departmentHandler = new DepartmentHandler("张主任");
        CollegeHandler collegeHandler = new CollegeHandler("李院长");
        ViceSchoolMasterHandler viceSchoolMasterHandler = new ViceSchoolMasterHandler("王副校长");
        SchoolMasterHandler schoolMasterHandler = new SchoolMasterHandler("黄校长");

        // 设置各个审批节点(形成链状结构)
        departmentHandler.setHandler(collegeHandler);
        collegeHandler.setHandler(viceSchoolMasterHandler);
        viceSchoolMasterHandler.setHandler(schoolMasterHandler);
        schoolMasterHandler.setHandler(departmentHandler);

        departmentHandler.processRequest(purchaseRequest);
//        collegeHandler.processRequest(purchaseRequest);
    }
}
