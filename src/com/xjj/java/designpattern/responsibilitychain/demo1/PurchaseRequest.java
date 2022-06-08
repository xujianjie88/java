package com.xjj.java.designpattern.responsibilitychain.demo1;

import lombok.Data;

/**
 * π∫¬Ú«Î«Û
 */
@Data
public class PurchaseRequest {

    private int type = 0;
    private float price = 0.0f;
    private int id;

    public PurchaseRequest(int type,float price, int id) {
        this.type = type;
        this.price = price;
        this.id = id;
    }


}
