package interface_adaptors.arr;

import use_cases.arr.ARRInputBoundary;
import use_cases.arr.ARRInputData;

public class RemoveController extends AddController{

    public ARRInputBoundary removeObj;

    public RemoveController(ARRInputBoundary removeObj)
    {
        super(removeObj);
        this.removeObj = removeObj;

    }

    public void removeItem(String serialNo, int quantity)
    {
        int negQuantity = -quantity;
        ARRInputData data = new ARRInputData(serialNo, negQuantity);
        removeObj.changeItemQuantity(data);

    }
}
