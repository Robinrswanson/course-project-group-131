package UseCases;

import Entities.*;
import java.util.*;

public class UseCaseUpdate {

    public void updateQuantity(String serial_num, Employee e, int modified_quantity) throws Exception {
        // modified_quantity can be both positive and negative!
        Item item = TempDataStorage.getItem(serial_num);
        boolean check_authority = e.getUpdateItem();
        if (check_authority){
            int quantity = item.getQuantity() + modified_quantity;
            item.setQuantity(quantity);
        }else{
            throw new Exception("You don't have rights to update the quantity!");
        }
    }

    public boolean checkQuantity(String serial_num, int decreased_quantity) throws Exception{
        // You should call this method only if the modified_quantity is negative, and you
        // are calling this method to check if the quantity goes to negative or not.
        Item item = TempDataStorage.getItem(serial_num);
        int quantity = item.getQuantity();
        if (quantity - decreased_quantity >=0){
            return true;
        }else{
            throw new Exception("Quantity will be going to negative!");
        }
    }

    public void updatePrice(String serial_num, Employee e, double modified_price) throws Exception{
        // modified_price can be both positive and negative!
        Item item = TempDataStorage.getItem(serial_num);
        boolean check_authority = e.getUpdatePrice();
        if (check_authority){
            double price = item.getPrice() + modified_price;
            item.setPrice(price);
        }else{
            throw new Exception("You don't have rights to update the price!");
        }
    }

    public boolean checkPrice(String serial_num, double decreased_price) throws Exception{
        // You should call this method only if the modified_price is negative, and you
        // are calling this method to check if the price goes to negative or not.
        Item item = TempDataStorage.getItem(serial_num);
        double price = item.getPrice();
        if (price - decreased_price >=0){
            return true;
        }else{
            throw new Exception("Price will be going to negative!");
        }
    }

    public void updateCategory(String serial_num, Employee e, List<String> new_category) throws Exception{
        Item item = TempDataStorage.getItem(serial_num);
        boolean check_authority = e.getUpdateItem();
        if (check_authority){
            item.setCategories(new_category);
        }else{
            throw new Exception("You don't have rights to update the category!");
        }
    }

    public void updateStorageLocation(String serial_num, Employee e, String StorageLocation) throws Exception{
        Item item = TempDataStorage.getItem(serial_num);
        boolean check_authority = e.getUpdateItem();
        if (check_authority){
            item.setStorageLocation(StorageLocation);
        }else{
            throw new Exception("You don't have rights to update the storage location!");
        }
    }
}
