package com.xjj.java.designpattern.responsibilitychain;

/**
 *Ժ��
 */
public class CollegeHandler extends Handler {

    public CollegeHandler(String name) {
        super(name);
    }

    @Override
    public void processRequest(PurchaseRequest purchaseRequest) {
        if (5000 <= purchaseRequest.getPrice() && purchaseRequest.getPrice() <= 10000) {
            System.out.println("������ id = " + purchaseRequest.getId() + "��" + this.name + "����");
        }else {
            handler.processRequest(purchaseRequest);
        }
    }
}
