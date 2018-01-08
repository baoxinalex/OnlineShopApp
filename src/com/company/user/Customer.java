package com.company.user;

import com.company.fileservices.FileServices;

import java.util.concurrent.atomic.AtomicInteger;

public class Customer extends User {
    private int customerID=100000;
    private String address;
    private int phone;

    public Customer(int customerID, String firstName, String lastName, String title, String address, int phone, String email) {
        super(firstName, lastName, title, email);
        if(customerID==0) {
            this.customerID = this.customerID + getNumberOfCustomers();
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

    public int getPhone() {
        return phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    //This adds significant more traffic to reading files
    private int getNumberOfCustomers(){
        FileServices fs = new FileServices();
        return fs.loadCustomers().size();
    }

    @Override
    public String toString(){
        return getTitle()+"."+this.getFirstName()+" "+getLastName()+"\t\t"+this.getEmail()+"\t\t"+this.getCustomerID()+"\t\t"+this.getAddress()+"\t\t"+this.getPhone()+"\n";
    }
}
