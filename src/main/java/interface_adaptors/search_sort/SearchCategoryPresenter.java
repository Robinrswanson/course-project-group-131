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
    public void prepareSuccess(ArrayList<Item> data) {
        String message = null;

        if (data.size() == 0){
            message =  "No Items found";}
        else{
            ArrayList<String> itemNames = new ArrayList<>();
            for (Item item: data)
            {itemNames.add(item.getName());}
            message = "Items: " + itemNames;
        }
        screen.setMessage(message);

    }
}
