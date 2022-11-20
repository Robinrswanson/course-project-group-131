package UseCases;

public interface AddInputBoundary {

    /**
     * Increases the quantity of the item, with data contained in the Data Structure
     * @param data contains serial number of the item and quantity to add
     * @return a String displaying successes or failures
     */
    String addItem(AddDS data);
}

