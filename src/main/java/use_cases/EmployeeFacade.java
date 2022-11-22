package use_cases;


import interface_adaptors.AddPresenter;

public class EmployeeFacade implements EmployeeFacadeInterface {
    String userName;

    public String addItem(AddDS data, AddOutputBoundary presenter)
    {
        Addable obj = new AddUseCase(presenter);
        return obj.addItem(data);
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
