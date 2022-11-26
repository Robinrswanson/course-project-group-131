package use_cases;

import java.util.ArrayList;
import java.util.List;
import entities.*;

public class ExportInventory {
    ExportInventory(){
    }
    public List<String[]> extractDataStorage(){
        List<Item> inventory = new ArrayList<Item>(TempDataStorage.getInventory().values());
        List<String[]> inventoryData = new ArrayList<String[]>();
        for(Item item: inventory){
            String[] rowData = {item.getName(), String.valueOf(item.getPrice()), String.valueOf(item.getQuantity()), item.getCategories().toString(), String.valueOf(item.getExpirationDates()), item.getStorageLocation()};
            inventoryData.add(rowData);
        }
        return inventoryData;
    }
}
