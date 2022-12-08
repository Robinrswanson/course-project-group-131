package use_cases.export_inventory;

import interface_adaptors.export_inventory.ExportPresenter;
import interface_adaptors.gateway.GatewayReader;
import interface_adaptors.gateway.GatewayWriter;
import interface_adaptors.inventory_initializer.InitializerController;
import org.junit.jupiter.api.Test;
import use_cases.initializer.InitializeUseCase;

import java.io.IOException;
import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExportInventoryTest {
    @Test
    void create() throws ParseException, IOException {
        ExportOutputBoundary presenter = new ExportPresenter() {
            @Override
            public String prepareSuccess(String filepath) {
                assertEquals("src/main/java/database/Database.csv", filepath);
                return null;
            }
        };
        InitializerController initializerController = new InitializerController() {
            @Override
            public void InitializeInventory() throws ParseException, IOException {
                GatewayReader reader = new GatewayReader("src/test/java/TestingSampleData/SampleInventory.csv");
                InitializeUseCase initializer = new InitializeUseCase(); //Creates the use case
                initializer.initializeInventory(reader); //Calls inventory initializer method
            }
        };

        initializerController.InitializeInventory();
        ExportInputBoundary interactor = new Export(presenter);
        GatewayWriter writer = new GatewayWriter("src/test/java/TestingSampleData/SampleInventory.csv");

        interactor.extractDataStorage(writer);
    }
}
