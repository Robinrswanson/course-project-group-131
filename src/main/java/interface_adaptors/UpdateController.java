package interface_adaptors;

import use_cases.*;

public class UpdateController {
    private UpdateInputBoundary updateUseCase;

    public UpdateController(UpdateInputBoundary useCase){
        this.updateUseCase = useCase;
    }

    /**
     * The controller packages the data and sends it off to the Update Use Case
     * @param serialNum the serial number of the item
     * @param price the price to update(for manager only)
     * @return a String for the View  to present
     */

    public String updateItem_quantity(String serialNum, double price, boolean updatePrice){
        UpdateDS data = new UpdateDS(serialNum, price, updatePrice);
        return this.updateUseCase.updateItem(data);
    }


}
