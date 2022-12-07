package interface_adaptors.arr;

import use_cases.arr.ARRInputBoundary;
import use_cases.arr.ARRInputData;

public class RemoveController extends AddController{

    public ARRInputBoundary removeObj;
    private String userName;

    RemoveController(ARRInputBoundary removeObj, String UserName)
    {
        super(removeObj, UserName);
        this.removeObj = removeObj;
        this.userName = UserName;

    }

    public void removeItem(String serialNo, int quantity)
    {
        ARRInputData data = new ARRInputData(serialNo, quantity, this.userName);
        removeObj.changeItemQuantity(data);

    }
}
