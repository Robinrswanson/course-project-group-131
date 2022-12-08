package use_cases.import_inventory;

import entities.TempDataStorage;
import interface_adaptors.gateway.GatewayReader;
import interface_adaptors.import_inventory.ImportPresenter;
import interface_adaptors.inventory_initializer.InitializerController;
import org.junit.jupiter.api.Test;
import use_cases.arr.ARRInputData;
import use_cases.initializer.InitializeUseCase;

import java.io.IOException;
import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.*;

public class ImportInventoryMultipleItemTest {
    @Test
    void create() throws ParseException, IOException {
        ImportOutputBoundary presenter = new ImportPresenter() {
            @Override
            public void prepareSuccess() {
                assertTrue(TempDataStorage.hasItem("1"));
                String[] expected1 = {"1", "Ice Cream", "9.99", "25", "N/A", "N/A", "Frozen"};
                String[] expected2 = {"8", "Chicken", "2.00", "87", "N/A", "12-04-2022", "Meats"};
                String[] expected3 = {"18", "Homogenized Milk", "2.99", "160", "N/A", "12-09-2022", "Dairy"};
                assertArrayEquals(expected1, TempDataStorage.getItem("1").getStringArrayFormat());
                assertArrayEquals(expected2, TempDataStorage.getItem("8").getStringArrayFormat());
                assertArrayEquals(expected3, TempDataStorage.getItem("18").getStringArrayFormat());
            }

            @Override
            public void prepareFailure(int value, ARRInputData itemInformation) {
                fail("Use case failure is unexpected.");
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
        ImportInputBoundary interactor = new Import(presenter);
        GatewayReader reader = new GatewayReader("src/test/java/TestingSampleData/Multiple Items.csv");

        interactor.importDatabase(reader);
    }
}
