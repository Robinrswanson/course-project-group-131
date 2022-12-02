package interface_adaptors.inventory_initializer;

import interface_adaptors.gateway.GatewayReader;
import use_cases.initializer.InitializeUseCase;
import use_cases.initializer.InitializerInputBoundary;

import java.io.IOException;
import java.text.ParseException;

public class InitializerController {

    public InitializerController(){

    }

    public void InitializeInventory() throws ParseException, IOException {
        GatewayReader reader = new GatewayReader("src/main/java/database/Database.csv");
        InitializeUseCase initializer = new InitializeUseCase();
        initializer.initializeInventory(reader);
    }
}
