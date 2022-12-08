package interface_adaptors.arr;

import use_cases.arr.ARRInputBoundary;
import use_cases.arr.ARRInputData;


public class ReturnController extends AddController
{
    /**
     * A controller for the ReturnUseCase. It creates an ARRInputData dat object and makes
     * a call to the ReturnUseCase
     */

    public ARRInputBoundary returnObj;

    /**
     *
     * @param returnObj Object of type ARRInputBoundary used to call the ReturnUseCase.
     */
    public ReturnController(ARRInputBoundary returnObj)
    {
        super(returnObj);
        this.returnObj = returnObj;
    }

    /**
     * Wraps the primitive serialNO and quantity data to an ARRInputData object
     * and calls the changeItemQuantity() method in ReturnUseCase
     *
     * @param serialNo Serial number of the item entered by the user
     * @param quantity The quantity of the item that the user wants to retur
     */
    public void returnItem(String serialNo, int quantity)
    {
        ARRInputData data = new ARRInputData(serialNo, quantity);
        returnObj.changeItemQuantity(data);
    }
}
