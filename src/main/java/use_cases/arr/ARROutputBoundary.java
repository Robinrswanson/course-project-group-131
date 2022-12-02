package use_cases.arr;

import interface_adaptors.arr.ARRIView;
import use_cases.arr.ARRInputData;

public interface ARROutputBoundary {

    int NEGATIVE_INT_ERROR = 0; // error code for if a negative integer was selected for quantity
    int SERIAL_NUM_NOT_FOUND_ERROR = 1; // error code for if the entered serial number is not found (will replace)

    void setScreen(ARRIView screen);
    void prepareSuccess(ARRInputData data); // display for if the Add Use Case is successful
    void prepareFailure(int error); // display for if the Add Use Case is unsuccessful

}

