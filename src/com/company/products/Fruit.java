package com.company.products;

public class Fruit extends Product{
    private int[] sweetnessRate={1,2,3,4,5};
    private int sweetness;


    public Fruit(String productName, int quantity, double price, int sweetness) {
        super(productName, quantity, price);
        if(sweetness==this.sweetnessRate[sweetness-1]) {
            this.sweetness = sweetness;
        }
    }

    public int getSweetness() {
        return sweetness;
    }

    public String toString(){
        return "Name: "+this.getProductName()+"\t\t"+"Quantity: "+this.getQuantity()+"\t\t"+"Price: "+this.getPrice()+"\t\t"+"Sweetness: "+this.getSweetness()+"\n";
    }
}
