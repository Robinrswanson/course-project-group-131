package interface_adaptors.arr;

import use_cases.arr.ARRInputData;
import use_cases.arr.ARROutputBoundary;

public class AddPresenter implements ARROutputBoundary {

    ARRIView screen;

    /**
     * Sets the screen the AddPresenter will update. The reason why it's not instantiated in the constructor
     * is due to the peculiar order the presenter, controller, use case and screen are made
     * @param screen the screen the presenter will change
     */
    public void setScreen(ARRIView screen){
        this.screen = screen;
    }

    /**
     * Called if item addition is successful
     * @param data a Data Structure containing a serial number and quantity to display
     */
    @Override
    public void prepareSuccess(ARRInputData data) {
        String message =  Integer.toString(data.getQuantity()) + " item(s) with serial number " +
                data.getSerialNum() + " were successfully added";
        screen.setMessage(message);
    }

    /**
     * Called if item addition is unsuccessful
     * @param error the error code
     */
    @Override
    public void prepareFailure(int error) {

        String message = null;

        if (error == NEGATIVE_INT_ERROR){
            message = "Error: Please enter a valid quantity";
        }
        else if (error == SERIAL_NUM_NOT_FOUND_ERROR){
            message = "Error: Serial number not found";
        }
        screen.setMessage(message);
    }
}

