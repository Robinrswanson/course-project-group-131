package entities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class Item {
    private final String serialNumber;
    private final String name;
    private double price;
    private int quantity;
    private List<String> categories;
    private Date expirationDates;
    private String storageLocation;

    public Item(String serialNumber, String name, double price, int quantity, List<String> categories,
         Date expirationDates, String storagelocation){
        this.serialNumber = serialNumber;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.categories = categories;
        this.expirationDates = expirationDates;
        this.storageLocation = storagelocation;
    }
    public String getSerialNumber(){return this.serialNumber;}
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

    public void setCategories(List<String> categories){
        this.categories = categories;
    }

    public void setStorageLocation(String storagelocation){
        this.storageLocation = storagelocation;
    }

    public boolean isCategory(String category){
        return this.categories.contains(category);
    }

    public void add(int quantity){
        this.quantity += quantity;
    }

    public boolean IsExpired(){
        long millis = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(millis);
        return this.expirationDates.compareTo(date) < 0;
    }

    public String[] getArrayFormat(){
            String formatedCategories = this.getCategories().toString().replace("[", "").replace("]", "");
            String[] arrayFormat = {this.getSerialNumber(), this.getName(), String.valueOf(this.getPrice()),
            String.valueOf(this.getQuantity()), formatedCategories,
            this.getDateStringFormat(), this.getStorageLocation()};
            return arrayFormat;
    }
    public String getDateStringFormat(){
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return dateFormat.format(this.expirationDates);
    }
}
