package com.company.cart;

import com.company.products.Product;
import java.util.concurrent.atomic.AtomicInteger;

public class Purchase {

    private static AtomicInteger purchaseIDGenerator = new AtomicInteger(10000);

    private int customerID;
    private Product product;
    private int quantityPurchased;
    private int purchaseID;

    public Purchase(int customerID, Product product, int quantityPurchased) {
        this.customerID = customerID;
        this.product = product;
        this.quantityPurchased = quantityPurchased;
        this.purchaseID=purchaseIDGenerator.getAndIncrement();
    }

    public int getCustomerID() {
        return customerID;
    }

    public String getProductName() {
        return this.product.getProductName();
    }

    public int getQuantityPurchased() {
        return quantityPurchased;
    }
}
