package use_cases.update_price;

public interface UpdatePriceInputBoundary {

    /**
     * Update the price of the item, with data contained in UpdateDS
     * @param data contains serial number of the item, the price to update, and if that staff has the
     *             rights to update price or not.
     * @return a String displaying successes or failures
     */
    String updateItem(UpdatePriceInputData data);
}
