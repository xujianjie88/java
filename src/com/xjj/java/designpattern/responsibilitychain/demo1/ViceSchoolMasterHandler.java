package com.xjj.java.designpattern.responsibilitychain.demo1;

/**
 * ��У��
 */
public class ViceSchoolMasterHandler extends Handler {

    public ViceSchoolMasterHandler(String name) {
        super(name);
    }

    @Override
    public void processRequest(PurchaseRequest purchaseRequest) {
        if (10000 <= purchaseRequest.getPrice() && purchaseRequest.getPrice() <= 30000) {
            System.out.println("������ id = " + purchaseRequest.getId() + "��" + this.name + "����");
        }else {
            handler.processRequest(purchaseRequest);
        }
    }
}
