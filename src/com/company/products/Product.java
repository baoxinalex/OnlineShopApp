package com.company.products;

import com.company.Discountable;

public class Product implements Discountable{

    private String productName;
    private int quantity;
    private double price;
    private double discountedPrice;

    public Product(String productName, int quantity, double price) {
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
        this.discountedPrice = price;
    }

    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }



    @Override
    public void setDiscountedPrice(double discountRate) {
        if(discountRate>=0 && discountRate<=1) {
            discountedPrice = price * (1 - discountRate);
        }
        else {
            try {
                throw new Exception("Discount rate should be between 0 and 1.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public double getDiscountedPrice() {
        return discountedPrice;
    }

    @Override
    public boolean equals(Object obj){
        if(!(obj instanceof Product)){
            return false;
        }
        return this.getProductName().toLowerCase().equals(((Product) obj).getProductName().toLowerCase());
    }

    @Override
    public int hashCode(){
        return productName.hashCode();
    }
}
