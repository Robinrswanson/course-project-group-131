package use_cases.arr;

public class ReturnUseCase extends Add implements ARRInputBoundary
{
    /**
     * ReturnUseCase return the given quantity of the item.
     */


    private static final String ACTION = "Return";

    /**
     * ReturnUseCase Object created by the ReturnScreenBuilder
     * @param presenter A presenter object of type ARROutputBoundary, initialised by ReturnScreenBuilder
     */
    public ReturnUseCase(ARROutputBoundary presenter)
    {
        super(presenter);
    }

    /**
     * Makes a call to the changeItemQuantity method in the super class Add, to increase
     * the quantity by the value being returned.
     *
     * @param data contains serial number of the item and quantity to add
     */
    public void changeItemQuantity(ARRInputData data)
    {
        super.changeItemQuantity(data);
        //updateHistory();
    }
    /*
    private void updateHistory()
    {
        History obj = new History(employeeId, ACTION, serialNo, increasedQuantity);
        obj.updateReturnHistory();
    }
    */


}
