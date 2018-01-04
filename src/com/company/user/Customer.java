package com.company.user;

import java.util.concurrent.atomic.AtomicInteger;

public class Customer extends User {
    private static final AtomicInteger idGenerator = new AtomicInteger(100000);
    private int customerID;
    private String address;
    private String phone;

    public Customer(int customerID, String firstName, String lastName, String title, String email, String address, String phone) {
        super(firstName, lastName, title, email);
        if(customerID==0) {
            this.customerID=idGenerator.getAndIncrement();
        }else{
            this.customerID=customerID;
        }
        this.address = address;
        this.phone = phone;
    }

    public int getCustomerID() {
        return customerID;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString(){
        return getTitle()+"."+this.getFirstName()+" "+getLastName()+"\t\t"+this.getEmail()+"\t\t"+this.getCustomerID()+"\t\t"+this.getAddress()+"\t\t"+this.getPhone()+"\n";
    }
}
