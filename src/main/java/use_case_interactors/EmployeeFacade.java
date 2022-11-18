package use_case_interactors;

public class EmployeeFacade implements EmployeeFacadeInterface{
    String userName;

    public void addItem(String serialNo, int increasedQuantity)
    {
        Addable obj = new Add(userName);
        obj.addItem(serialNo, increasedQuantity);
    }

    public void returnItem(String serialNo, int increasedQuantity)
    {
        Returnable obj = new Return(userName, serialNo, increasedQuantity);
        obj.returnItem();
    }



}
