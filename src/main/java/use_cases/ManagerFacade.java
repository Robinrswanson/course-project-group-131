package use_cases;


import java.io.File;
import java.io.IOException;

public class ManagerFacade extends EmployeeFacade implements ManagerFacadeInterface
{
    public void updatePrice(){

    }
    public String importInventory(String filePath) throws IOException{
        Import importer = new Import(filePath);
        importer.importDatabase();
        return "Successful";
    }
    public File exportInventory(){
        Export exporter = new Export();
        File database = exporter.exportDatabase();
        return database;
    }

    public void sortItem(String category) {

    }
}
