package interface_adaptors.update_price;

import use_cases.update_price.UpdatePriceInputData;
import use_cases.update_price.UpdatePriceOutputBoundary;

public class UpdatePresenter implements UpdatePriceOutputBoundary {

    UpdateIview screen;

    public void setScreen(UpdateIview screen){
        this.screen = screen;
    }

    /**
     * Called if the price has been successfully updated
     * @param data contains serial number of the item, the price to update, and if that staff has the
     *                  rights to update price or not.
     */

    @Override
    public void prepareSuccess(UpdatePriceInputData data){
        String message = "the price of item(s) with serial number " + data.getSerialNum() +
                " has been updated to" + data.getPrice();
        screen.setMessage(message);
    }

    /**
     * Called if price updating is unsuccessful
     * @param error the error code
     */
    @Override
    public void prepareFailure(int error){
        if (error == NEGATIVE_DOUBLE_ERROR){
            String message =  "Error: Please enter a valid price";
            screen.setMessage(message);
        }
        else if (error == NOT_RIGHTS_TO_ACCESS){
            String message = "Only manager can update the price!";
            screen.setMessage(message);
        }else{
            String message = "Error: Serial number not found";
            screen.setMessage(message);
        }
    }
}
