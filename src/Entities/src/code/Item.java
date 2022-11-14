package entities.src.code;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class Item {

    private int quantity;
    private double price;
    private Date expirationDate;

    private String name;
    private String storageLocation;

    private List<String> categories = new ArrayList<>();

    public Item(String name, double price, String storageLocation){
        // very basic constructor, missing a lot of functionality
        // implementation dependent on the person working on the "add" use case
        quantity = 0;
        this.price = price;
        this.name = name;
        this.storageLocation = storageLocation;
    }

    public boolean isCategory(String category){
        return true;
    }


}
