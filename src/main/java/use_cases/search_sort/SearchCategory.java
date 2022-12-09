package use_cases.search_sort;

import entities.Item;
import entities.ItemInterface;
import entities.TempDataStorage;

import java.util.*;

public class SearchCategory implements SearchCatInputBoundary {
    private final SearchCatOutputBoundary presenter;
    Map<String, ItemInterface> inventory;

    public SearchCategory(SearchCatOutputBoundary presenter){
        this.inventory = TempDataStorage.getInventory();
        this.presenter = presenter;
    }

    /**
     * The Search categoreis use case, Once it executes, the presenter updates the information
     * @param categories this holds the categories that will be used as parameters for the search
     */
    public void SearchCategories(String[] categories){
        ArrayList<ItemInterface> itemList = new ArrayList<>();
        ArrayList<ItemInterface> inventoryList = new ArrayList<>(inventory.values());
        for (String category : categories) {
            for (ItemInterface item: inventoryList) {
                List<String> check = item.getCategories();
                if (check.contains(category) && !itemList.contains(item)){
                    itemList.add(item);}}}
            presenter.prepareSuccess(itemList);}

}
