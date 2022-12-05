package interface_adaptors.arr;

import use_cases.arr.ARRInputBoundary;
import use_cases.arr.ARRInputData;

public class ReturnController extends AddController
{
    ARRInputBoundary returnObj;
    ReturnController(ARRInputBoundary returnObj)
    {
        super(returnObj);
        this.returnObj = returnObj;
    }

    public void returnItem(String serialNo, int quantity)
    {
        ARRInputData data = new ARRInputData(serialNo, quantity);
        returnObj.changeItemQuantity(data);
    }
}
