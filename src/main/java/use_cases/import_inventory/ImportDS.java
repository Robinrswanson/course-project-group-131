package use_cases.import_inventory;

import java.util.List;

public class ImportDS {

    private final List<String[]> importData;

    public ImportDS(List<String[]> importData){
        this.importData = importData;
    }

    // simple getters to extract the data from ImportDS
    public List<String[]> getImportData(){
        return importData;
    }
}

