package use_cases;

import entities.Item;
import entities.TempDataStorage;

public class AddUseCase implements Addable {

    private final AddOutputBoundary presenter;

    public AddUseCase(AddOutputBoundary presenter){
        this.presenter = presenter;
    }

    /**
     *
     * @param data a Data Structure containing the serial number and quantity of the item to add
     * @return a string for the view to show the user (created by the presenter)
     */
    public String addItem(AddDS data){

        if (data.getQuantity() < 0){
            return presenter.prepareFailure(0);
        } // if the employee enters a negative quantity (unlikely, but you don't want this to happen at all)
        else if (! TempDataStorage.hasItem(data.getSerialNum())){
            return presenter.prepareFailure(1);
        } // can remove this later, assuming that serial number entered is never incorrect - just kept in for now for testing purposes

        Item item = TempDataStorage.getItem(data.getSerialNum());

        int quantity = item.getQuantity() + data.getQuantity();
        item.setQuantity(quantity);
        return presenter.prepareSuccess(data);
    }
}
