package interface_adaptors;

import use_cases.gatewayWriterInterface;

import java.io.*;
import java.util.List;

public class gatewayWriter implements gatewayWriterInterface {
    private final File file;


    public gatewayWriter(String filePath) {
        this.file = new File(filePath);
    }

    public void addNewLines(String[] newRowData) throws IOException {
        try {
            // could possibly change row and col to search for item name
            gatewayReader reader = new gatewayReader(file);
            List<String[]> fileContents = reader.getData();
            fileContents.add(newRowData);

            PrintWriter pw = new PrintWriter(new FileWriter(file));
            for (String[] rowData : fileContents) {
                String line = String.join(",", rowData);
                pw.println(line);
            }
            pw.flush();
            pw.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void editSingleCell(String replace, int row, int col) throws IOException {
        try {
            // could possibly change row and col to search for item name
            gatewayReader reader = new gatewayReader(file);
            List<String[]> fileContents = reader.getData();
            // contents to be updated are searched using row and col in csv file
            fileContents.get(row)[col] = replace;
            // entire file is rewritten as there is no replace method for CSVWriter
            FileWriter fileWriter = new FileWriter(file);
            PrintWriter pw = new PrintWriter(fileWriter);
            for (String[] rowData : fileContents) {
                String line = String.join(",", rowData);
                pw.println(line);
            }
            pw.flush();
            pw.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void rewriteFile(List<String[]> newFileContents) {
        try {
            FileWriter fileWriter = new FileWriter(file);
            PrintWriter pw = new PrintWriter(fileWriter);
            for (String[] rowData : newFileContents) {
                String line = String.join(",", rowData);
                pw.println(line);
            }
            pw.flush();
            pw.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    //Add another method that allows multiple changes to be made
//  Could use same writeToFile method but instead pass in arrays

}
