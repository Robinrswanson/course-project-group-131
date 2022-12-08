package use_cases.arr;

import entities.Item;
import entities.ItemInterface;

public interface ARRInputBoundary {

    /**
     * Increases the quantity of the item, with data contained in the Data Structure
     * @param data contains serial number of the item and quantity to add
     * @return a String displaying successes or failures
     */
    void changeItemQuantity(ARRInputData data);

    /**
     * Updates History by making a call to the ChangeHistory method to record the changes
     * made by the user
     *
     * @param data Represents the ARRInputData containing Serial No and quantity
     * @param item Represents the item object that was modified
     */

    void updateHistory(ARRInputData data, ItemInterface item);

}

