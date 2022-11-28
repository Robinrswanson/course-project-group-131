package use_cases;

public class ReturnUseCase extends AddUseCase implements Returnable
{
    private String employeeId;
    private String serialNo;
    private int increasedQuantity;

    private static final String ACTION = "Return";

    ReturnUseCase(String employeeId, String serialNo, int increasedQuantity)
    {
        super();
        this.employeeId = employeeId;
        this.serialNo = serialNo;
        this.increasedQuantity = increasedQuantity;
    }
    public void returnItem()
    {
        super.addItem(employeeId, serialNo, increasedQuantity);
        updateHistory();
    }

    private void updateHistory()
    {
        History obj = new History(employeeId, ACTION, serialNo, increasedQuantity);
        obj.updateReturnHistory();
    }

}
