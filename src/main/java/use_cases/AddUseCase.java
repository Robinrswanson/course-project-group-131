package use_cases;

import entities.Item;
import entities.TempDataStorage;

public class AddUseCase implements AddInputBoundary{

    private final AddOutputBoundary presenter;

    public AddUseCase(AddOutputBoundary presenter){
        this.presenter = presenter;
    }

    /**
     *
     * @param data a Data Structure containing the serial number and quantity of the item to add
     * @return a string for the view to show the user (created by the presenter)
     */
    public void addItem(AddDS data){

        Item item = TempDataStorage.getItem(data.getSerialNum());
        int quantity = item.getQuantity() + data.getQuantity();
        item.setQuantity(quantity);
    }

    @Override
    public boolean serialNumberValid(String serialNum) {
        return TempDataStorage.hasItem(serialNum);
    }
}
