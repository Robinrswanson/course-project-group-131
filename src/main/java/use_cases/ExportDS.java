package use_cases;

import java.util.List;

public class ExportDS {
    List<String[]> database;
    public ExportDS(List<String[]> exportData){
        this.database = exportData;
    }
    public void addData(String[] rowData){
        database.add(rowData);
    }
    public List<String[]> getDatabase(){
        return this.database;
    }
}
