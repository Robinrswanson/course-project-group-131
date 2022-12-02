package entities;

import java.util.*;

public class SearchCategory {
    String[] categories;
    Map<String, Item> inventory;

    public SearchCategory(String[] categories){
        this.categories = categories;
        this.inventory = TempDataStorage.getInventory();
    }
    public ArrayList<Item> SearchCategories(){
        // Loop through all the possible categories, add the items to a set.
        ArrayList<Item> itemList = new ArrayList<>();
        ArrayList<Item> inventoryList = new ArrayList<>(inventory.values());
        for (String category : categories) {
            for (Item item: inventoryList) {
                List<String> check = item.getCategories();
                if (check.contains(category) && !itemList.contains(item)){
                    itemList.add(item);}}}
            return itemList; }

}
