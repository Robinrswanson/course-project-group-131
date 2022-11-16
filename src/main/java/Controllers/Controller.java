package Controllers;
import java.io.IOException;
import java.util.List;
import UseCases.*;
import com.opencsv.exceptions.CsvException;

public class Controller {
    public Controller(String filePath) throws IOException, CsvException {
        gatewayReader reader = new gatewayReader(filePath);
        List<String[]> data = reader.getData();
        dataInterpreter interpreter = new dataInterpreter(data);

    }
}
