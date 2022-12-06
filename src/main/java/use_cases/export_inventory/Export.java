package use_cases.export_inventory;

import java.util.ArrayList;
import java.util.List;
import entities.*;
import use_cases.gateway_interfaces.GatewayWriterInterface;

public class Export implements ExportInputBoundary {

    private final ExportOutputBoundary presenter;

    public Export(ExportOutputBoundary presenter){
        this.presenter = presenter;
    }
    public void extractDataStorage(GatewayWriterInterface writer){
        //Get List form of the inventory
        List<Item> inventory = new ArrayList<>(TempDataStorage.getInventory().values());
        ExportDS inventoryData = new ExportDS(new ArrayList<>());
        for(Item item: inventory){
            //format the item information into a String Array
            String[] rowData = item.getArrayFormat();
            inventoryData.addData(rowData);
        }
        //write to the file
        writer.rewriteFile(inventoryData.getDatabase());
        presenter.prepareSuccess(inventoryData.getFilePath()); //display that method completed successfully
    }
}
