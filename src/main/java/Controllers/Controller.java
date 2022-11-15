package Controllers;
import Controllers.gatewayReader;
import java.io.File;
import java.util.ArrayList;
import use_cases.*;

public class Controller {
    public Controller(File file){
        gatewayReader reader = new gatewayReader(file);
        ArrayList<String> data = reader.getData();
        dataInterpreter interpreter = new dataInterpreter(data);

    }
}
