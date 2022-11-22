package interface_adaptors;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class gatewayReader {

    private final File file;

    public gatewayReader(String filePath){
        this.file = new File(filePath);
    }

    public gatewayReader(File file){
        this.file = file;
    }
/*
    public List<String[]> getData() throws IOException, CsvException {
            CSVReader reader = new CSVReader(new FileReader(file));
            // Creates a List of String Arrays where each index of the List is a row and each element of the String
        // Array is the cell value starting from the first column
            List<String[]> fileData = reader.readAll();
            reader.close();
            return fileData;
    }
    */
    public List<String[]> getData() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        List<String[]> fileData = new ArrayList<>();
        String st;
        while ((st = reader.readLine()) != null){
            String[] rowData = st.split(",");
            fileData.add(rowData);
        }
        return fileData;
    }


}
