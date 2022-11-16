import Controllers.*;
import com.opencsv.exceptions.CsvException;

import java.io.IOException;
import java.util.List;

public class Main{
    public static void main(String[] args) throws CsvException, IOException {
        String file = "src\\main\\java\\Database\\Sample Data - Sample Item.csv";
        gatewayReader reader = new gatewayReader(file);
        List<String[]> data = reader.getData();
        for (String[] item : data) {
            for (String x : item) {
                System.out.println(x);
            }
        }
        gatewayWriter writer = new gatewayWriter(file);
        writer.writeToFile("5", 1, 2);
        gatewayReader reader2 = new gatewayReader(file);
        List<String[]> data2 = reader2.getData();
        for (String[] item : data2) {
            for (String x : item) {
                System.out.println(x);
            }
        }
        String[] newLine = {""};
        writer.addNewLines(newLine);
    }
}
