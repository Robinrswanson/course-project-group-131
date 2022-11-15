package entities.src.code;

import java.util.*;

public class Item {
    private String name;
    private double price;
    private int quantity;
    private List<String> categories;
    private Date expirationDates;
    private String storageLocation;

    Item(String name, double price, int quantity, List<String> categories,
         Date expirationDates, String storagelocation){
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.categories = categories;
        this.expirationDates = expirationDates;
        this.storageLocation = storagelocation;
    }

    Item(String name, double price, int quantity, List<String> categories,
         String storagelocation){
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.categories = categories;
        this.storageLocation = storagelocation;
    }

    public String getName(){
        return this.name;
    }

    public double getPrice(){
        return this.price;
    }

    public int getQuantity(){
        return this.quantity;
    }

    public List<String> getCategories(){
        return this.categories;
    }

    public Date getExpirationDates(){
        return this.expirationDates;
    }

    public String getStorageLocation(){
        return this.storageLocation;
    }

    public void setQuantity(int quantity){
        this.quantity = quantity;
    }

    public void setPrice(double price){
        this.price = price;
    }

    public boolean isCategory(String category){
        if (this.categories.contains(category)){
            return true;
        }else{
            return false;
        }
    }

    public void add(int quantity){
        this.quantity += quantity;
    }

    public boolean IsExpired(){
        long millis = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(millis);
        if (this.expirationDates.compareTo(date) >= 0){
            return false;
        }else{
            return true;
        }
    }
}
