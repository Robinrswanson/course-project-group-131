package interface_adaptors;

import use_cases.ImportOutputBoundary;

public class ImportPresenter implements ImportOutputBoundary {

    @Override
    public String prepareSuccess(String filepath) {
        return "Inventory has been successfully imported.";
    }

    @Override
    public String prepareFailure(int value, String[] lst) {
        if (value == 0){
            return "Error: " + lst[0] + " not found in inventory.";
        }
        else{
            return "Error: " + lst[0] + " has invalid quantity.";
        }
    }
}
