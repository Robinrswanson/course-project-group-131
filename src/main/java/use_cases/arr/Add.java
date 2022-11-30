package use_cases.arr;

import entities.Item;
import entities.TempDataStorage;

public class Add implements ARRInputBoundary {

    private final ARROutputBoundary presenter;

    public Add(ARROutputBoundary presenter){
        this.presenter = presenter;
    }

    /**
     *
     * @param data a Data Structure containing the serial number and quantity of the item to add
     * @return a string for the view to show the user (created by the presenter)
     */
    public void changeItemQuantity(ARRInputData data){

        if (data.getQuantity() < 0){
            presenter.prepareFailure(ARROutputBoundary.NEGATIVE_INT_ERROR);
        } // if the employee enters a negative quantity (unlikely, but you don't want this to happen at all)
        else if (!TempDataStorage.hasItem(data.getSerialNum())){
            presenter.prepareFailure(ARROutputBoundary.SERIAL_NUM_NOT_FOUND_ERROR);
        }
        else{
            Item item = TempDataStorage.getItem(data.getSerialNum());
            int quantity = item.getQuantity() + data.getQuantity();
            item.setQuantity(quantity);
            presenter.prepareSuccess(data);
        }
    }
}
