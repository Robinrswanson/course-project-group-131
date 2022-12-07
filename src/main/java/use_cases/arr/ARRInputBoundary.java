package use_cases.arr;

import entities.Item;

public interface ARRInputBoundary {

    /**
     * Increases the quantity of the item, with data contained in the Data Structure
     * @param data contains serial number of the item and quantity to add
     * @return a String displaying successes or failures
     */
    void changeItemQuantity(ARRInputData data);

    void updateHistory(ARRInputData data, Item item);

}

