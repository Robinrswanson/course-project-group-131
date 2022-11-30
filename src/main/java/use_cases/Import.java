package use_cases;

import java.io.IOException;
import java.util.List;
import entities.Item;
import entities.TempDataStorage;
import interface_adaptors.ImportPresenter;

public class Import implements ImportInputBoundary{
    private final ImportOutputBoundary presenter;
    public Import(ImportOutputBoundary presenter){
        this.presenter = presenter;
    }

    /**
     * imports the passed in inventory
     * @param reader a class that reads files
     * @return a String that says whether the inventory was successfully imported or failed
     * @throws IOException
     */
    public String importDatabase(gatewayReaderInterface reader) throws IOException{
        ImportDS importData = new ImportDS(reader.getData(), reader.getFilePath());
        List<String[]> data = importData.getImportData();
        data.remove(0); //Remove the column titles from the data
        for (String[] lst: data) {
            AddDS itemInformation = new AddDS(lst[0], Integer.valueOf(lst[3]));
            if (!TempDataStorage.hasItem(itemInformation.getSerialNum())) {
                return presenter.prepareFailure(0, itemInformation); // Check that item is in inventory
            } else if (itemInformation.getQuantity() < 0) {
                return presenter.prepareFailure(1, itemInformation); // Check that quantity is not negative
            }
            Item item = TempDataStorage.getItem(itemInformation.getSerialNum());
            int newQuantity = item.getQuantity() + itemInformation.getQuantity();
            item.setQuantity(newQuantity);
        }
        return presenter.prepareSuccess();
    }
}
