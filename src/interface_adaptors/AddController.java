package interface_adaptors;

import use_cases.*;

public class AddController {

    private AddInputBoundary addUseCase;

    public AddController(AddInputBoundary useCase){
        this.addUseCase = useCase;
    }

    /**
     * The controller packages the data and sends it off to the Add Use Case
     * @param serialNum the serial number of the item
     * @param quantity the quantity to add
     * @return a String for the View to present
     */
    public String addItem(String serialNum, int quantity){
        AddDS data = new AddDS(serialNum, quantity);
        return addUseCase.addItem(data);
    }
}

