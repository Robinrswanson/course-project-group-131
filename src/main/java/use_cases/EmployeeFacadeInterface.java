package use_cases;

public interface EmployeeFacadeInterface {

    String addItem(AddDS data, AddOutputBoundary presenter);
    void returnItem(String serialNo, int increasedQuantity);
    void searchItem();
    void sortItem();

}
