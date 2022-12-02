package use_cases.import_inventory;

import use_cases.arr.ARRInputData;

public interface ImportOutputBoundary {

    String prepareSuccess(); // display if the use case succeeded

    String prepareFailure(int value, ARRInputData data); //Display if the use case failed

}
