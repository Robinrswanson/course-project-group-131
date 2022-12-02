package interface_adaptors.import_inventory;

import use_cases.arr.ARRInputData;
import use_cases.import_inventory.ImportOutputBoundary;

public class ImportPresenter implements ImportOutputBoundary {
    /**
     * Called if import is successful
     * @return a String value for the View to present
     */
    @Override
    public String prepareSuccess() {
        return "Inventory has been successfully imported.";
    }
    /**
     * Called if import is unsuccessful
     * @param value an integer that represents the type of error to present
     * @param itemInformation a data structure containing the item serial number and quantity
     * @return a String value for the View to present
     */

    @Override
    public String prepareFailure(int value, ARRInputData itemInformation) {
        if (value == 0){
            return "Error: " + itemInformation.getSerialNum() + " not found in inventory.";
        }
        else{
            return "Error: " + itemInformation.getQuantity() + " has invalid quantity.";
        }
    }
}
