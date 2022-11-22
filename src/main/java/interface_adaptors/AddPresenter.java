package interface_adaptors;

import use_cases.*;

public class AddPresenter implements AddOutputBoundary {

    /**
     * Called if item addition is successful
     * @param data a Data Structure containing a serial number and quantity to disply
     * @return a String value for the View to present
     */
    @Override
    public String prepareSuccess(AddDS data) {
        return Integer.toString(data.getQuantity()) + "item(s) with serial number " +
                data.getSerialNum() + " were successfully added";
    }

    /**
     * Called if item addition is unsuccessful
     * @param error the error code
     * @return a String error for the View to present
     */
    @Override
    public String prepareFailure(int error) {
        if (error == NEGATIVE_INT_ERROR){
            return "Error: Please enter a valid quantity";
        }
        else{
            return "Error: Serial number not found";
        }
    }
}

