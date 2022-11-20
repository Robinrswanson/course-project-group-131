package use_case_interactors;

public class Return implements Returnable extends Add
{
    private String employeeId;
    private String serialNo;
    private int increasedQuantity;

    private static final String ACTION = "Return";

    Return(String employeeId, String serialNo, int increasedQuantity)
    {
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
