package entities;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Item {
    private final String serialNumber;
    private final String name;
    private double price;
    private int quantity;
    private List<String> categories;
    private final Date expirationDates;
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
    public Item(String[] itemInfo) throws ParseException {
        this.serialNumber = itemInfo[0];
        this.name = itemInfo[1];
        this.price = Double.parseDouble(itemInfo[2]);
        this.quantity = Integer.parseInt(itemInfo[3]);
        List<String> categories = new ArrayList<>(Arrays.asList(itemInfo[4].split(";")));
        this.categories = categories;
        if (itemInfo[5] != "N/A"){
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date date = dateFormat.parse(itemInfo[5]);
            this.expirationDates = date;}
        else{
            this.expirationDates = null;
        }
        this.storageLocation = itemInfo[6];
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
            String formattedCategories = this.getCategories().toString().replace("[", "").replace("]", "");
            String[] arrayFormat = {this.getSerialNumber(), this.getName(), String.valueOf(this.getPrice()),
            String.valueOf(this.getQuantity()), formattedCategories,
            this.getDateStringFormat(), this.getStorageLocation()};
            return arrayFormat;
    }
    public String getDateStringFormat(){
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return dateFormat.format(this.expirationDates);
    }
}
