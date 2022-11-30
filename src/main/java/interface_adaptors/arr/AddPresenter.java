package interface_adaptors.arr;

import use_cases.arr.ARRInputData;
import use_cases.arr.ARROutputBoundary;

public class AddPresenter implements ARROutputBoundary {

    /**
     * Called if item addition is successful
     * @param data a Data Structure containing a serial number and quantity to display
     * @return a String value for the View to present
     */

    ARRIView screen;

    public void setScreen(ARRIView screen){
        this.screen = screen;
    }


    @Override
    public void prepareSuccess(ARRInputData data) {
        String message =  Integer.toString(data.getQuantity()) + " item(s) with serial number " +
                data.getSerialNum() + " were successfully added";
        screen.setMessage(message);
    }

    /**
     * Called if item addition is unsuccessful
     * @param error the error code
     * @return a String error for the View to present
     */
    @Override
    public void prepareFailure(int error) {

        String message;

        if (error == NEGATIVE_INT_ERROR){
            message = "Error: Please enter a valid quantity";
        }
        else{
            message = "Error: Serial number not found";
        }
        screen.setMessage(message);
    }
}

