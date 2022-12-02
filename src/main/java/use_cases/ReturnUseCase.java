package use_cases;

public class ReturnUseCase extends AddUseCase implements Returnable
{
    private String employeeId;
    private String serialNo;
    private int increasedQuantity;

    private static final String ACTION = "Return";

    ReturnUseCase(ReturnOutputBoundaryInterface presenter)
    {
        super(presenter);
    }
    public void returnItem()
    {
        super.addItem(ArrInputData data);
        updateHistory();
    }

    private void updateHistory()
    {
        History obj = new History(demployeeId, ACTION, serialNo, increasedQuantity);
        obj.updateReturnHistory();
    }

}
