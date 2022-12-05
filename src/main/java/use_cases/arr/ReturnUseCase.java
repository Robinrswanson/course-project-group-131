package use_cases.arr;

public class ReturnUseCase extends Add implements ARRInputBoundary
{


    private static final String ACTION = "Return";

    ReturnUseCase(ARROutputBoundary presenter)
    {
        super(presenter);
    }
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
