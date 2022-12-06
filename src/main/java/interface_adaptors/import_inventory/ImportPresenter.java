package interface_adaptors.import_inventory;

import use_cases.arr.ARRInputData;
import use_cases.import_inventory.ImportOutputBoundary;

public class ImportPresenter implements ImportOutputBoundary {
    /**
     * Called if import is successful
     * @return a String value for the View to present
     */

    ImportIView screen;

    public void setScreen(ImportIView screen){
        this.screen = screen;
    }

    @Override
    public void prepareSuccess() {
        String message = "Inventory has been successfully imported.";
        screen.setMessage(message);

    }
    /**
     * Called if import is unsuccessful
     * @param value an integer that represents the type of error to present
     * @param itemInformation a data structure containing the item serial number and quantity
     * @return a String value for the View to present
     */

    @Override
    public void prepareFailure(int value, ARRInputData itemInformation) {
        String message = null;
        if (value == 0){
            message = "Error: " + itemInformation.getSerialNum() + " not found in inventory.";
        }
        else{
            message = "Error: " + itemInformation.getQuantity() + " has invalid quantity.";
        }
        screen.setMessage(message);
    }
}
