package use_case_interactors;

public interface EmployeeFacadeInterface {

    public void addItem(String serialNo, int increasedQuantity);
    public void returnItem(String serialNo, int increasedQuantity);
    public void searchItem();
    public void sortItem();

}
