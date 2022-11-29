package interface_adaptors;

import entities.TempDataStorage;
import use_cases.*;

public class AddController {

    private AddInputBoundary addUseCase;
    private AddOutputBoundary addPresenter;

    public AddController(AddInputBoundary useCase, AddOutputBoundary addPresenter){
        this.addUseCase = useCase;
        this.addPresenter = addPresenter;
    }

    /**
     * The controller packages the data and sends it off to the Add Use Case
     * @param serialNum the serial number of the item
     * @param quantity the quantity to add
     * @return a String for the View to present
     */
    public String addItem(String serialNum, int quantity){
        if (quantity < 0){
            return addPresenter.prepareFailure(0);
        } // if the employee enters a negative quantity (unlikely, but you don't want this to happen at all)


        AddDS data = new AddDS(serialNum, quantity);

        if (! addUseCase.addItem(data)){
            addPresenter.prepareFailure(1);
        }
        // can remove this later, assuming that serial number entered is never incorrect - just kept in for now for testing purposes
        return addPresenter.prepareSuccess(data);

    }
}

