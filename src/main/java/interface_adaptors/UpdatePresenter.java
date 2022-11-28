package interface_adaptors;

import use_cases.*;

public class UpdatePresenter implements UpdateOutputBoundary {

    /**
     * Called if the price has been successfully updated
     * @param data contains serial number of the item, the price to update, and if that staff has the
     *                  rights to update price or not.
     * @return a String value for the View to present
     */

    @Override
    public String prepareSuccess(UpdateDS data){
        return "the price of item(s) with serial number " + data.getSerialNum() +
                "has been updated to" + data.getPrice();
    }

    /**
     * Called if price updating is unsuccessful
     * @param error the error code
     * @return a String error for the View to present
     */
    @Override
    public String prepareFailure(int error){
        if (error == NEGATIVE_DOUBLE_ERROR){
            return "Error: Please enter a valid price";
        }
        else if (error == NOT_RIGHTS_TO_ACCESS){
            return "Only manager can update the price!";
        }
        else{
            return "Error: Serial number not found";
        }
    }
}
