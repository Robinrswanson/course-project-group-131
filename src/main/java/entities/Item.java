package entities;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Item implements ItemInterface{
    private final String serialNumber;
    private final String name;
    private double price;
    private int quantity;
    private List<String> categories;
    private final Date expirationDates;
    private String storageLocation;

    public Item(String serialNumber, String name, double price, int quantity, List<String> categories,
                Date expirationDates, String storagelocation) {
        this.serialNumber = serialNumber;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.categories = categories;
        this.expirationDates = expirationDates;
        this.storageLocation = storagelocation;
    }
    public Item(String[] itemInfo) throws ParseException {
            this.serialNumber = itemInfo[SERIAL_NUMBER_INDEX];
            this.name = itemInfo[NAME_INDEX];
            this.price = Double.parseDouble(itemInfo[PRICE_INDEX]);
            this.quantity = Integer.parseInt(itemInfo[QUANTITY_INDEX]);
            this.categories = new ArrayList<>(Arrays.asList(itemInfo[CATEGORY_INDEX].split(";")));
            if(itemInfo[DATE_INDEX].equals("N/A")){
                this.expirationDates = null;}
            else{
                DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
                this.expirationDates = dateFormat.parse(itemInfo[DATE_INDEX]);}
            this.storageLocation = itemInfo[STORAGE_INDEX];
    }
    public String getSerialNumber() {
        return this.serialNumber;
    }

    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public List<String> getCategories() {
        return this.categories;
    }

    public Date getExpirationDates() {
        return this.expirationDates;
    }

    public String getStorageLocation() {
        return this.storageLocation;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    public void setStorageLocation(String storagelocation) {
        this.storageLocation = storagelocation;
    }

    public boolean isCategory(String category) {
        return this.categories.contains(category);
    }

    public void add(int quantity) {
        this.quantity += quantity;
    }

    public boolean IsExpired() {
        long millis = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(millis);
        return this.expirationDates.compareTo(date) < 0;
    }

    public String[] getStringArrayFormat() {
        String formattedCategories = this.getCategories().toString().replace("[", "").replace("]", "");
        return new String[]{this.getSerialNumber(), this.getName(), String.format("%.2f", this.getPrice()),
                String.valueOf(this.getQuantity()), formattedCategories,
                this.getDateStringFormat(), this.getStorageLocation()};
    }

    public String getDateStringFormat() {
        if (this.expirationDates == null) {
            return "N/A";
        }
        DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
        return dateFormat.format(this.expirationDates);
    }
}
