package use_cases;

public interface AddInputBoundary {

    /**
     * Increases the quantity of the item, with data contained in the Data Structure
     * @param data contains serial number of the item and quantity to add
     * @return a String displaying successes or failures
     */
    void addItem(AddDS data);

    boolean serialNumberValid(String serialNum);
}

