package use_cases.import_inventory;

import interface_adaptors.import_inventory.ImportIView;
import use_cases.arr.ARRInputData;

public interface ImportOutputBoundary {
    int NEGATIVE_INT_ERROR = 1; // error code for if a negative integer was selected for quantity
    int SERIAL_NUM_NOT_FOUND_ERROR = 0; // error code for if the entered serial number is not found (will replace)

    void setScreen(ImportIView screen);

    void prepareSuccess(); // display if the use case succeeded

    void prepareFailure(int value, ARRInputData data); //Display if the use case failed

}
