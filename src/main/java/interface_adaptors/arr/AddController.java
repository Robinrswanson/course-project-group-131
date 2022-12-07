package interface_adaptors.arr;

import use_cases.arr.ARRInputBoundary;
import use_cases.arr.ARRInputData;

public class AddController {

    private ARRInputBoundary addUseCase;
    private String userName;

    public AddController(ARRInputBoundary useCase, String userName){
        this.addUseCase = useCase;
        this.userName = userName;
    }

    /**
     * The controller packages the data and sends it off to the Add Use Case
     * @param serialNum the serial number of the item
     * @param quantity the quantity to add
     * @return a String for the View to present
     */
    public void addItem(String serialNum, int quantity){

        ARRInputData data = new ARRInputData(serialNum, quantity, this.userName);

        // can remove this later, assuming that serial number entered is never incorrect - just kept in for now for testing purposes
        addUseCase.changeItemQuantity(data);
        // made a change to the controller - again

    }
}

