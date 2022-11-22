package interface_adaptors;

import use_cases.*;

public class AddController {

    private EmployeeFacadeInterface employeeFacade;
    private AddOutputBoundary presenter;

    public AddController(EmployeeFacadeInterface employeeFacade, AddOutputBoundary presenter){
        this.employeeFacade = employeeFacade;
        this.presenter = presenter;
    }

    /**
     * The controller packages the data and sends it off to the Add Use Case
     * @param serialNum the serial number of the item
     * @param quantity the quantity to add
     * @return a String for the View to present
     */
    public String addItem(String serialNum, int quantity){
        AddDS data = new AddDS(serialNum, quantity);
        return employeeFacade.addItem(data, presenter);
    }
}

