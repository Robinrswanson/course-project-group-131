package interface_adaptors.update_price;

import use_cases.update_price.UpdatePriceInputBoundary;
import use_cases.update_price.UpdatePriceInputData;

public class UpdateController {
    private UpdatePriceInputBoundary updateUseCase;

    public UpdateController(UpdatePriceInputBoundary useCase){
        this.updateUseCase = useCase;
    }

    /**
     * The controller packages the data and sends it off to the Update Use Case
     * @param serialNum the serial number of the item
     * @param price the price to update(for manager only)
     */

    public void updateItem_price(String serialNum, double price){
        UpdatePriceInputData data = new UpdatePriceInputData(serialNum, price);
        this.updateUseCase.updateItem(data);
    }



}
