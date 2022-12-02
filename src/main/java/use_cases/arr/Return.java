package use_cases.arr;

import use_cases.arr.ARRInputBoundary;
import use_cases.arr.ARRInputData;
import use_cases.arr.ARROutputBoundary;
import use_cases.arr.Add;

public class Return extends Add implements ARRInputBoundary {


    public Return(ARROutputBoundary returnPresenter){
        super(returnPresenter);
    }
    // previously, the constructor took in an Employee ID, serial number and quantity to change
    // I've replaced this (for now) to just take in the presenter. In main, this will be a presenter specific to Return

    public void changeItemQuantity(ARRInputData data)
    {
        super.changeItemQuantity(data);
        // updateHistory();
    }


    /*
    private void updateHistory(String serialNo, int increasedQuantity)
    {
        History obj = new History();
        obj.updateReturnHistory(employeeId, serialNo, increasedQuantity);
    }
    */
    // this is definitely an inplementation we'll need to do when we come together as a team

}
