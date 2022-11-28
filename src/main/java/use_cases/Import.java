package use_cases;

import java.util.List;
import entities.Item;
import entities.TempDataStorage;
import interface_adaptors.ImportPresenter;

public class Import implements ImportInputBoundary{
    private final ImportOutputBoundary presenter;
    public Import(ImportOutputBoundary presenter){
        this.presenter = presenter;
    }
    public String importDatabase(ImportDS importData){
        List<String[]> data = importData.getImportData();
        data.remove(0);
        for (String[] lst: data) {
            String serial_num = lst[0];
            int quantity = Integer.valueOf(lst[3]);
            if (!TempDataStorage.hasItem(serial_num)) {
                return presenter.prepareFailure(0, lst);
            } else if (quantity < 0) {
                return presenter.prepareFailure(1, lst);
            }
            Item item = TempDataStorage.getItem(serial_num);
            int newQuantity = item.getQuantity() + quantity;
            item.setQuantity(newQuantity);
        }
        return presenter.prepareSuccess(importData.getFilepath());
        /**
         * Here I want to add the data to the storage
         * I add to the tempdatastorage
         *Should I add a data checker to ensure that all entries are valid or assume import file is valid
         * Should I use the AddDS?
        **/
    }
}
