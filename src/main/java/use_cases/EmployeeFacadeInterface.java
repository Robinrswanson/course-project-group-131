package use_cases;

public interface EmployeeFacadeInterface {

    void addItem(String serialNo, int increasedQuantity);
    void returnItem(String serialNo, int increasedQuantity);
    void searchItem();
    void sortItem();

}