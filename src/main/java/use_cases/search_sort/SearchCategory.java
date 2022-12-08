package use_cases.search_sort;

import entities.Item;
import entities.TempDataStorage;

import java.util.*;

public class SearchCategory implements SearchCatInputBoundary {
    private final SearchCatOutputBoundary presenter;
    Map<String, Item> inventory;

    public SearchCategory(SearchCatOutputBoundary presenter){
        this.inventory = TempDataStorage.getInventory();
        this.presenter = presenter;
    }

    /**
     * The Search categoreis use case, Once it executes, the presenter updates the information
     * @param categories this holds the categories that will be used as parameters for the search
     */
    public void SearchCategories(String[] categories){
        ArrayList<Item> itemList = new ArrayList<>();
        ArrayList<Item> inventoryList = new ArrayList<>(inventory.values());
        for (String category : categories) {
            for (Item item: inventoryList) {
                List<String> check = item.getCategories();
                if (check.contains(category) && !itemList.contains(item)){
                    itemList.add(item);}}}
            presenter.prepareSuccess(itemList);}

}
