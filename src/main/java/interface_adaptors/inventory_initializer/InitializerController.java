package interface_adaptors.inventory_initializer;

import interface_adaptors.gateway.GatewayReader;
import use_cases.initializer.InitializeUseCase;

import java.io.IOException;
import java.text.ParseException;

public class InitializerController {

    public void InitializeInventory() throws ParseException, IOException {
        GatewayReader reader = new GatewayReader("src/main/java/database/Database.csv");
        InitializeUseCase initializer = new InitializeUseCase(); //Creates the use case
        initializer.initializeInventory(reader); //Calls inventory initializer method
    }
}
