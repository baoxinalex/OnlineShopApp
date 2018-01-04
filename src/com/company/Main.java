package com.company;

import com.company.fileservices.FileServices;
import com.company.products.Fruit;
import com.company.products.Product;
import com.company.user.Admin;
import com.company.user.Customer;
import com.company.user.User;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
//        Customer testCustomer1 = new Customer("Test1","Test1","MR","fake1@email.com","fake address1","1123456");
//        Customer testCustomer2 = new Customer("Test2","Test2","MR","fake2@email.com","fake address2","2123456");
//        Customer testCustomer3 = new Customer("Test3","Test3","MR","fake3@email.com","fake address3","3123456");
//        System.out.println(testCustomer1.getCustomerID());
//        System.out.println(testCustomer2.getCustomerID());
//        System.out.println(testCustomer3.getCustomerID());



        Fruit apple = new Fruit("apple",10,0.3,1);
        Product pear = new Fruit("pear",10,0.25,3);


        Customer testCustomer4 = new Customer(0, "Test4","Test4","MR","fake4@email.com","fake address4","4124456");
        FileServices fs = new FileServices();
        ArrayList<Customer> customers = fs.loadCustomers();
        customers.add(testCustomer4);
        for(Customer customer: customers){
            System.out.println(customer.toString());
            System.out.println(customer.getCustomerID());
        }

//        ArrayList<Customer> customers = fs.loadCustomers();
//        customers.add(testCustomer1);
//        customers.add(testCustomer2);
//        customers.add(testCustomer3);
//        fs.writeCustomer();
//
//        ArrayList<Fruit> fruits = fs.loadFruits();
//        for(Fruit fruit: fruits) {
//            System.out.println(fruit.toString());
//        }
//        System.out.println(apple.getDiscountedPrice());
//        apple.setDiscountedPrice(0.2);
//        System.out.println(apple.getDiscountedPrice());
//        apple.setDiscountedPrice(0.0);
//        System.out.println(apple.getDiscountedPrice());



    }
}
