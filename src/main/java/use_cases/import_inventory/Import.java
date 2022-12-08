package use_cases.import_inventory;

import java.io.IOException;
import java.util.List;
import entities.Item;
import entities.TempDataStorage;
import use_cases.gateway_interfaces.GatewayReaderInterface;
import use_cases.arr.ARRInputData;

public class Import implements ImportInputBoundary {
    private final ImportOutputBoundary presenter;
    public Import(ImportOutputBoundary presenter){
        this.presenter = presenter;
    }

    /**
     * imports the passed in inventory
     * @param reader a class that reads files
     * @return a String that says whether the inventory was successfully imported or failed
     */
    public void importDatabase(GatewayReaderInterface reader) throws IOException{
        ImportDS importData = new ImportDS(reader.getData());
        List<String[]> data = importData.getImportData();
        data.remove(0); //Remove the column titles from the data
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
            Item item = TempDataStorage.getItem(itemInformation.getSerialNum());
            int newQuantity = item.getQuantity() + itemInformation.getQuantity();
            item.setQuantity(newQuantity);
        }
        if (success){
            presenter.prepareSuccess();
        }
    }
}
