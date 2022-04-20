package com.xjj.java.designpattern.responsibilitychain;

/**
 * У��
 */
public class SchoolMasterHandler extends Handler {

    public SchoolMasterHandler(String name) {
        super(name);
    }

    @Override
    public void processRequest(PurchaseRequest purchaseRequest) {
        if (purchaseRequest.getPrice()>30000) {
            System.out.println("������ id = " + purchaseRequest.getId() + "��" + this.name + "����");
        }else {
            handler.processRequest(purchaseRequest);
        }

    }
}
