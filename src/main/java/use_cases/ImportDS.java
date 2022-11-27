package use_cases;

import java.util.List;

public class ImportDS {

    private List<String[]> importData;

    private String filepath;

    public ImportDS(List<String[]> importData, String filepath){
        this.importData = importData;
        this.filepath = filepath;
    }

    // simple getters to extract the data from AddDS
    public List<String[]> getImportData(){
        return importData;
    }

    public String getFilepath(){
        return filepath;
    };
}

