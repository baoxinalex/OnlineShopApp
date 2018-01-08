package com.company.fileservices;

import com.company.cart.Order;
import com.company.cart.Purchase;
import com.company.products.Fruit;
import com.company.products.Product;
import com.company.products.Vegetable;
import com.company.user.Admin;
import com.company.user.Customer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.util.ArrayList;

public class FileServices {
    private String commonFileLocation = System.getProperty("user.dir");
    private String customerFileLocation = "\\src\\com\\company\\resource\\customer.txt";
    private File customerFile= new File(commonFileLocation+customerFileLocation);
    private ArrayList<Customer> customers;

    private String adminFileLocation = "\\src\\com\\company\\resource\\admin.txt";
    private File adminFile= new File(commonFileLocation+adminFileLocation);


    private String fruitFileLocation = "\\src\\com\\company\\resource\\fruit.txt";
    private File fruitFile= new File(commonFileLocation+fruitFileLocation);
    private ArrayList<Fruit> fruits;

    private String vegFileLocation = "\\src\\com\\company\\resource\\vegetable.txt";
    private File vegFile= new File(commonFileLocation+vegFileLocation);
    private ArrayList<Vegetable> vegetables;

    private String purchaseFileLocation = "\\src\\com\\company\\resource\\purchase_record.txt";
    private File purchaseRecord= new File(commonFileLocation+purchaseFileLocation);
    private ArrayList<Purchase> purchases;
    private ArrayList<Order> orders;

    public ArrayList<Customer> loadCustomers() {

        customers = new ArrayList<>();
        if(!customerFile.exists() || !customerFile.canRead() || !customerFile.isFile()){
            System.out.println("Unable to find readable file: "+customerFile.getAbsolutePath());
        }
        try{
            BufferedReader br = new BufferedReader(new FileReader(customerFile));
            String line;
            while ((line=br.readLine()) != null){
                String[] field = line.split(",");
                String customerID = field[0];
                String title = field[1];
                String first_name = field[2];
                String last_name = field[3];
                String email = field[4];
                String phone = field[5];
                String address = field[6];

                customers.add( new Customer(Integer.parseInt(customerID), first_name,last_name,title,address,Integer.parseInt(phone),email));
            }
            br.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return customers;
    }

    public ArrayList<Admin> loadAdmins() {

        ArrayList<Admin> admins = new ArrayList<>();
        if(!adminFile.exists() || !adminFile.canRead() || !adminFile.isFile()){
            System.out.println("Unable to find readable file: "+adminFile.getAbsolutePath());
        }
        try{
            BufferedReader br = new BufferedReader(new FileReader(adminFile));
            String line;
            while ((line=br.readLine()) != null){
                String[] field = line.split(",");
                String first_name = field[0];
                String last_name = field[1];
                String title = field[2];
                String email = field[3];
                String password = field[4];

                admins.add( new Admin(first_name,last_name,title,email,password));
            }
            br.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return admins;
    }

    public ArrayList<Fruit> loadFruits() {

        fruits = new ArrayList<>();
        if(!fruitFile.exists() || !fruitFile.canRead() || !fruitFile.isFile()){
            System.out.println("Unable to find readable file: "+fruitFile.getAbsolutePath());
        }

        try{
            BufferedReader br = new BufferedReader(new FileReader(fruitFile));
            String line;
            while ((line=br.readLine()) != null){
                String[] field = line.split(",");
                String productName = field[0];
                String quantity  = field[1];
                String price = field[2];
                String sweetness = field[3];

                fruits.add( new Fruit(productName,Integer.parseInt(quantity),Double.parseDouble(price), Integer.parseInt(sweetness)));
            }
            br.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return fruits;
    }

    public ArrayList<Vegetable> loadVegetables() {
        vegetables = new ArrayList<>();
        if(!vegFile.exists() || !vegFile.canRead() || !vegFile.isFile()){
            System.out.println("Unable to find readable file: "+vegFile.getAbsolutePath());
        }
        try{
            BufferedReader br = new BufferedReader(new FileReader(vegFile));
            String line;
            while ((line=br.readLine()) != null){
                String[] field = line.split(",");
                String productName = field[0];
                String quantity = field[1];
                String price = field[2];
                String organicLabel = field[3];

                vegetables.add( new Vegetable(productName,Integer.parseInt(quantity),Double.parseDouble(price),Boolean.parseBoolean(organicLabel)));
            }
            br.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return vegetables;
    }

    private ArrayList<Product> loadProducts(){
        ArrayList<Product> products = new ArrayList<>();
        products.addAll(loadFruits());
        products.addAll(loadVegetables());
        return products;
    }

    public ArrayList<Order> loadPurchase(){
        purchases = new ArrayList<>();
        orders = new ArrayList<>();
        if(!purchaseRecord.exists() || !purchaseRecord.canRead() || !purchaseRecord.isFile()){
            System.out.println("Unable to find readable file: "+purchaseRecord.getAbsolutePath());
        }
        try{
            BufferedReader br = new BufferedReader(new FileReader(purchaseRecord));
            String line;

            while ((line=br.readLine()) != null){
                String[] field = line.split(",");
                String orderID = field[0];
                String customerID = field[1];
                String productName = field[2];
                String quantity = field[3];

                for(Product product: loadProducts()){
                    if(product.getProductName().equals(productName)){
                        orders.add( new Order(Integer.parseInt(customerID), product, Integer.parseInt(quantity)));
                    }
                }
                //not complete yet
            }
            br.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return orders;
    }

    public void writeCustomer(){
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(customerFile, false));
            for (Customer customer: customers){
                bw.write(customer.getCustomerID()+","+customer.getTitle()+","+customer.getFirstName()+","+customer.getLastName()+","+customer.getEmail()+","+customer.getPhone()+","+customer.getAddress());
                bw.newLine();
            }
            bw.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    public void writeFruits(){
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(fruitFile, false));
            for (Fruit fruit: fruits){
                bw.write(fruit.getProductName()+","+fruit.getQuantity()+","+fruit.getPrice()+","+fruit.getSweetness());
                bw.newLine();
            }
            bw.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    public void writeVegetables(){
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(vegFile, false));
            for (Vegetable vegetable: vegetables){
                bw.write(vegetable.getProductName()+","+vegetable.getQuantity()+","+vegetable.getPrice()+","+vegetable.isOrganicLabel());
                bw.newLine();
            }
            bw.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    public void writePurchase(){
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(vegFile, false));
            for (Purchase purchase: purchases){
                bw.write(""); //not completed yet
                bw.newLine();
            }
            bw.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
