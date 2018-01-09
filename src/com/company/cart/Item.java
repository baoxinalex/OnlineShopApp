package com.company.cart;

import com.company.products.Product;

public class Item {


    private Product product;
    private int quantity;

    public Item(Product product, int quantityPurchased) {

        this.product = product;
        this.quantity = quantityPurchased;
    }

    public String getProductName() {
        return product.getProductName();
    }

    public int getQuantityPurchased() {
        return quantity;
    }

    public String toString(){
        return product.getProductName()+"\t"+quantity;
    }
}
