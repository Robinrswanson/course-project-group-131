import java.io.IOException;
import java.util.List;
import use_cases.*;
public class Main{
    public static void main(String[] args) throws IOException {
        String file = "src\\main\\java\\Database\\Sample Data - Sample Item.csv";
        Reader reader = new Reader(file);
        List<String[]> data = reader.getData();
        for (String[] item : data) {
            for (String x : item) {
                System.out.println(x);
            }
        }
        Writer writer = new Writer(file);
        writer.writeToFile("3", 1, 2);
        /*
        Reader reader2 = new Reader(file);
        List<String[]> data2 = reader2.getData();
        for (String[] item : data2) {
            for (String x : item) {
                System.out.println(x);
            }
        }
        String[] newLine = {""};
        writer.addNewLines(newLine);
        */

    }
}
