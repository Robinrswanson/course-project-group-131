package use_cases;

import java.util.ArrayList;
import java.util.List;
import entities.*;

public class Export implements ExportInputBoundary{
    Export(){
    }
    public ExportDS extractDataStorage(){
        List<Item> inventory = new ArrayList<Item>(TempDataStorage.getInventory().values());
        ExportDS inventoryData = new ExportDS(new ArrayList<String[]>());
        for(Item item: inventory){
            String[] rowData = {item.getName(), String.valueOf(item.getPrice()), String.valueOf(item.getQuantity()), item.getCategories().toString(), String.valueOf(item.getExpirationDates()), item.getStorageLocation()};
            inventoryData.addData(rowData);
        }
        return inventoryData;
    }
}
