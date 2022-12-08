package interface_adaptors.gateway;

import use_cases.gateway_interfaces.GatewayWriterInterface;

import java.io.*;
import java.util.List;

public class GatewayWriter implements GatewayWriterInterface {
    private final File file;
    private final String filePath;


    public GatewayWriter(String filePath) {
        this.file = new File(filePath);
        this.filePath = filePath;
    }

    public void addNewLines(String[] newRowData) {
        try {
            // could possibly change row and col to search for item name
            GatewayReader1 reader = new GatewayReader1(filePath);
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

    public void editSingleCell(String replace, int row, int col) {
        try {
            GatewayReader1 reader = new GatewayReader1(filePath);
            List<String[]> fileContents = reader.getData();
            fileContents.get(row)[col] = replace;
            PrintWriter pw = new PrintWriter(new FileWriter(filePath));
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
