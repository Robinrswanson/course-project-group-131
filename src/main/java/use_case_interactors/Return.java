package use_case_interactors;

public class Return implements Returnable extends Add
{
    private String employeeId;
    private String serialNo;
    private int increasedQuantity;

    Return(String employeeId, String serialNo, int increasedQuantity)
    {
        this.employeeId = employeeId;
        this.serialNo = serialNo;
        this.increasedQuantity = increasedQuantity;
    }
    public void returnItem()
    {
        super.addItem(obj, serialNo, increasedQuantity);
        updateHistory();
    }

    private void updateHistory(String serialNo, int increasedQuantity)
    {
        History obj = new History();
        obj.updateReturnHistory(employeeId, serialNo, increasedQuantity);
    }

}
