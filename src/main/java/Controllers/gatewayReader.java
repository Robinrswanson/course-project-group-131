package Controllers;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class gatewayReader {

    private final File file;

    public gatewayReader(String filePath){
        this.file = new File(filePath);
    }

    public List<String[]> getData() throws IOException, CsvException {
            CSVReader reader = new CSVReader(new FileReader(file));
            // Creates a List of String Arrays where each index of the List is a row and each element of the String
        // Array is the cell value starting from the first column
            List<String[]> fileData = reader.readAll();
            reader.close();
            return fileData;
    }


}
