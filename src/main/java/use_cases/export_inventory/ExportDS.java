package use_cases.export_inventory;

import java.util.List;

public class ExportDS {
    //Data structure containing the filePath for Database and a List of each item in inventory's information
    List<String[]> database;
    String filePath;
    public ExportDS(List<String[]> exportData){
        this.database = exportData;
        this.filePath = "src/main/java/database/Database.csv";
    }
    public void addData(String[] rowData){
        database.add(rowData);
    } //Add item information to the
    public List<String[]> getDatabase(){
        return this.database;
    }
    public String getFilePath(){return this.filePath;}
}
