package interface_adaptors;

import entities.Item;

import java.util.List;

public class SearchPresenter {

    /**
     * Called if item addition is successful
     * @param data a Data Structure containing an item and True value or a False Value
     * @return a String value for the View to present
     */
    public String prepareSuccess(List<Object> data) {
        // TODO should this also return information about the expiration data and categories?
        if ((boolean) data.get(0)) {
            Item item =  (Item) data.get(1);
            return "Item:" + item.getName() + ", Cost:" + Double.toString(item.getPrice()) +
                    ", Quantity:" + Integer.toString(item.getQuantity()) + ", Storage Location:" +
                    item.getStorageLocation();
        }
        else {
            return "Item was not found";
        }

    }
}
