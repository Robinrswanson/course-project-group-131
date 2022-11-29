package use_cases;

import java.util.List;

public class ExportDS {
    List<String[]> database;
    String filePath;
    public ExportDS(List<String[]> exportData){
        this.database = exportData;
        this.filePath = "src/main/java/database/Database.csv";
    }
    public void addData(String[] rowData){
        database.add(rowData);
    }
    public List<String[]> getDatabase(){
        return this.database;
    }
    public String getFilePath(){return this.filePath;}
}
