package interface_adaptors.search_sort;

import entities.Item;
import use_cases.search_sort.SearchCatOutputBoundary;


import java.util.ArrayList;

public class SearchCategoryPresenter implements SearchCatOutputBoundary {
    SearchCategoryIView screen;

    /**
     * Sets the screen the SearchCategoryPresenter will update. The reason why it's not instantiated in the constructor
     * is due to the peculiar order the presenter, controller, use case and screen are made
     * @param screen the screen the presenter will change
     */
    @Override
    public void setScreen(SearchCategoryIView screen) {this.screen = screen;}

    @Override
    public String prepareSuccess(ArrayList<Item> data) {
        ArrayList<String> itemNames = new ArrayList<>();
        for (Item item: data)
        {itemNames.add(item.getName());}
        return "Items: " + itemNames;
    }
}
