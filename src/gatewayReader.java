import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

;

public class gatewayReader {

    String path = "C:\\Users\\ken_w\\Desktop\\Uoft 2022-2023\\Fall 2022\\CSC 207 Software design\\UserName Password.csv";
    String line = "";

    BufferedReader br;

    {
        try {
            br = new BufferedReader(new FileReader(path));
            while (true) {
                try {
                    if ((line = br.readLine()) == null) break;
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


}