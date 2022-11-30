package interface_adaptors;

import use_cases.AddDS;
import use_cases.ImportOutputBoundary;

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
    public String prepareFailure(int value, AddDS itemInformation) {
        if (value == 0){
            return "Error: " + itemInformation.getSerialNum() + " not found in inventory.";
        }
        else{
            return "Error: " + itemInformation.getQuantity() + " has invalid quantity.";
        }
    }
}
