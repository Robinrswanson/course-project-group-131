package use_cases;

import java.util.ArrayList;
import java.util.List;
import entities.*;

public class Export implements ExportInputBoundary{

    private final ExportOutputBoundary presenter;

    public Export(ExportOutputBoundary presenter){
        this.presenter = presenter;
    }
    public String extractDataStorage(gatewayWriterInterface writer){
        List<Item> inventory = new ArrayList<>(TempDataStorage.getInventory().values());
        ExportDS inventoryData = new ExportDS(new ArrayList<>());
        for(Item item: inventory){
            String[] rowData = {item.getName(), String.valueOf(item.getPrice()), String.valueOf(item.getQuantity()), item.getCategories().toString(), String.valueOf(item.getExpirationDates()), item.getStorageLocation()};
            inventoryData.addData(rowData);
        }
        writer.rewriteFile(inventoryData.getDatabase());
        return presenter.prepareSuccess(inventoryData.getFilePath());
    }
}
