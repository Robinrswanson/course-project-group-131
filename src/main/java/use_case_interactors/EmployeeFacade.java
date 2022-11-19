package use_case_interactors;


public class EmployeeFacade implements EmployeeFacadeInterface{
    String userName;

    public void addItem(String serialNo, int increasedQuantity)
    {
        Addable obj = new Add(userName, serialNo, increasedQuantity);
        obj.addItem(serialNo, increasedQuantity);
    }

    public void returnItem(String serialNo, int increasedQuantity)
    {
        Returnable obj = new Return(userName, serialNo, increasedQuantity);
        obj.returnItem();
    }

    public void searchItem(String serialNo)
    {
        Searchable obj = new Search(serialNo);
        obj.searchItem();
    }

    public void filterItem(String category)
    {
        Filterable obj = new Filterable(serialNo);
        obj.filterItem();
    }

}
