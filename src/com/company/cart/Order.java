package com.company.cart;

import java.util.ArrayList;


public class Order {

    private ArrayList<Item> items;
    private int customerID;
    private int orderID=10000;

    //id is temperarily written in this way, it has to be reworked
    public Order(int orderID, int customerID, ArrayList<Item> items){
        this.customerID = customerID;
        if(orderID==0){
            this.orderID++;
        }
        else{
            this.orderID=orderID;
        }
        this.items = items;
    }

    public int getOrderID() {
        return orderID;
    }

    public int getCustomerID() {
        return customerID;
    }
}
