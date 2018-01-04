package com.company.products;

public class Vegetable extends Product{
    private boolean organicLabel;

    public Vegetable(String productName, int quantity, double price, boolean organicLabel) {
        super(productName, quantity, price);
        this.organicLabel = organicLabel;
    }

    public boolean isOrganicLabel() {
        return organicLabel;
    }

    public String toString(){
        return "Name: "+this.getProductName()+"\t\t"+"Quantity: "+this.getQuantity()+"\t\t"+"Price: "+this.getPrice()+"\t\t"+"Organic: "+this.isOrganicLabel()+"\n";
    }
}
