import java.util.*;

public class Item {
    String Name;
    double Price;
    int Quantity;
    List Categories;
    Date ExpirationDates;
    String StorageLocation;

    Item(String name, double price, int quantity, List categories,
         Date expirationDates, String storagelocation){
        this.Name = name;
        this.Price = price;
        this.Quantity = quantity;
        this.Categories = categories;
        this.ExpirationDates = expirationDates;
        this.StorageLocation = storagelocation;
    }

    public boolean isCategory(String category){
        if (this.Categories.contains(category)){
            return true;
        }else{
            return false;
        }
    }

    public void add(int quantity){
        this.Quantity += quantity;
    }

    public boolean IsExpired(){
        long millis = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(millis);
        if (this.ExpirationDates.compareTo(date) >= 0){
            return false;
        }else{
            return true;
        }
    }
}
