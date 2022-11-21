package use_cases;

public interface UpdateInputBoundary {

    /**
     * Update the price of the item, with data contained in UpdateDS
     * @param data contains serial number of the item, the price to update, and if that staff has the
     *             rights to update price or not.
     * @return a String displaying successes or failures
     */
    String updateItem(UpdateDS data);
}
