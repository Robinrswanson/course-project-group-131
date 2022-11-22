package use_cases;

import use_cases.Reader;
import java.util.List;
import entities.TempDataStorage;

import java.io.IOException;

public class Import {
    private final String filePath;

    public Import(String filePath){
        this.filePath = filePath;
    }
    public boolean importDatabase() throws IOException{
        Reader fileReader = new Reader(filePath);
        List<String[]> dataToAdd = fileReader.getData();
        for (String[] lst: dataToAdd) {
            String serial_num = lst[0];
            String quantity = lst[1];
            // Here update the item in the tempdatastorage
        }
        /**
         * Here I want to add the data to the storage
         * I add to the tempdatastorage
         *Should I add a data checker to ensure that all entries are valid or assume import file is valid
        **/

        return true;
    }
}
