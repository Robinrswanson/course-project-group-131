package Controllers;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.io.File;

public class gatewayWriter {
    private final File file;

    public gatewayWriter(String filePath){
        this.file = new File(filePath);
    }

    public void addNewLines (String[] rowData) throws IOException {
        // Writes the next line of the CSVFile (use for history potentially)
        CSVWriter writer = new CSVWriter(new FileWriter(file));
        writer.writeNext(rowData);
    }


    public void writeToFile(String replace, int row, int col) throws IOException, CsvException {
        // could possibly change row and col to search for item name
        CSVReader reader = new CSVReader(new FileReader(file));
        List<String[]> fileContents = reader.readAll();
        // contents to be updated are searched using row and col in csv file
        fileContents.get(row)[col] = replace;
        reader.close();
        // entire file is rewritten as there is no replace method for CSVWriter
        CSVWriter writer = new CSVWriter(new FileWriter(file));
        writer.writeAll(fileContents);
        writer.flush();
        writer.close();
    }
    //Add another method that allows multiple changes to be made
}
