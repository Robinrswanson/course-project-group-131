package use_cases.import_inventory;

import interface_adaptors.import_inventory.ImportIView;
import use_cases.arr.ARRInputData;

public interface ImportOutputBoundary {

    void setScreen(ImportIView screen);

    void prepareSuccess(); // display if the use case succeeded

    void prepareFailure(int value, ARRInputData data); //Display if the use case failed

}
