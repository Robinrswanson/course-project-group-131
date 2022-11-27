package use_cases;


import interface_adaptors.ImportPresenter;

import java.util.List;

public class ManagerFacade extends EmployeeFacade implements ManagerFacadeInterface
{
    public void updatePrice(){

    }
    public String importInventory(ImportPresenter presenter, ImportDS database){
        Import importer = new Import(presenter);
        importer.importDatabase(database);
        return "Successful";
    }
    public void exportInventory(){
    }

    public void sortItem(String category) {

    }
}
