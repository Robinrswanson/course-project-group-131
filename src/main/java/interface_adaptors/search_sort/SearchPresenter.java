package interface_adaptors.search_sort;

import entities.Item;
import use_cases.search_sort.SearchOutputBoundary;

import java.util.ArrayList;

public class SearchPresenter implements SearchOutputBoundary {
    SearchIView screen;
    /**
     * Sets the screen the AddPresenter will update. The reason why it's not instantiated in the constructor
     * is due to the peculiar order the presenter, controller, use case and screen are made
     * @param screen the screen the presenter will change
     */
    @Override
    public void setScreen(SearchIView screen) {this.screen = screen;}

    /**
     * Called if item addition is successful
     * @param data a Data Structure containing a boolean denoting whether the item was found and the item
     *
     */
    @Override
    public String prepareSuccess(ArrayList<Object> data) {
        if ((boolean) data.get(0)) {
            Item item =  (Item) data.get(1);
            return "Item:" + item.getName() + ", Cost:" + item.getPrice() +
                    ", Quantity:" + item.getQuantity() + ", Storage Location:" +
                    item.getStorageLocation();
        }
        else {
            return "Item was not found";
        }

    }
}
