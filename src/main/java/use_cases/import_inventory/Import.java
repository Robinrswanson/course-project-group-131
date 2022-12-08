package use_cases.import_inventory;

import java.io.IOException;
import java.util.List;
import entities.Item;
import entities.ItemInterface;
import entities.TempDataStorage;
import use_cases.arr.ARRInputData;
import use_cases.gateway_interfaces.GatewayReaderInterface;

public class Import implements ImportInputBoundary {
    private final ImportOutputBoundary presenter;
    public Import(ImportOutputBoundary presenter){
        this.presenter = presenter;
    }

    /**
     * imports the passed in inventory
     * @param reader a class that reads files
     */
    public void importDatabase(GatewayReaderInterface reader) throws IOException{
        ImportDS importData = new ImportDS(reader.getData());
        List<String[]> data = importData.getImportData();
        boolean success = true;
        for (String[] lst: data) {
            ARRInputData itemInformation = new ARRInputData(lst[0], Integer.parseInt(lst[3]));
            if (!TempDataStorage.hasItem(itemInformation.getSerialNum())) {
                presenter.prepareFailure(0, itemInformation); // Check that item is in inventory
                success = false;
                break;
            } else if (itemInformation.getQuantity() < 0) {
                presenter.prepareFailure(1, itemInformation); // Check that quantity is not negative
                success = false;
                break;
            }
            ItemInterface item = TempDataStorage.getItem(itemInformation.getSerialNum());
            int newQuantity = item.getQuantity() + itemInformation.getQuantity();
            item.setQuantity(newQuantity);
        }
        if (success){
            presenter.prepareSuccess();
        }
    }
}
