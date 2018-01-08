package com.company.cart;

import java.util.ArrayList;


public class Purchase {

    private ArrayList<Order> orders;
    private int purchaseID=10000;


    //id is temperarily written in this way, it has to be reworked
    public Purchase(int orderID, ArrayList<Order> orders){
        if(orderID==0){
            this.purchaseID++;
        }
        else{
            this.purchaseID=purchaseID;
        }
        this.orders = orders;
    }

    public int getPurchaseID() {
        return purchaseID;
    }
}
