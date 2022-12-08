package use_cases.initialize_inventory;

import entities.TempDataStorage;
import interface_adaptors.gateway.GatewayReader;
import interface_adaptors.inventory_initializer.InitializerController;
import org.junit.jupiter.api.Test;
import use_cases.gateway_interfaces.GatewayReaderInterface;
import use_cases.initializer.InitializeUseCase;

import java.io.IOException;
import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class InitializeMultipleItemTest {
    @Test
    void create() throws ParseException, IOException {
        InitializerController initializerController = new InitializerController() {
            @Override
            public void InitializeInventory() throws ParseException, IOException {
                GatewayReaderInterface reader = new GatewayReader("src/test/java/TestingSampleData/Multiple Items.csv");
                InitializeUseCase initializer = new InitializeUseCase(); //Creates the use case
                initializer.initializeInventory(reader); //Calls inventory initializer method

                String[] expected1 = {"1", "Ice Cream", "9.99", "20", "N/A", "N/A", "Frozen"};
                String[] expected2 = {"8", "Chicken", "2.00", "17", "N/A", "12-04-2022", "Meats"};
                String[] expected3 = {"18", "Homogenized Milk", "2.99", "100", "N/A", "12-09-2022", "Dairy"};
                assertArrayEquals(expected1, TempDataStorage.getItem("1").getStringArrayFormat());
                assertArrayEquals(expected2, TempDataStorage.getItem("8").getStringArrayFormat());
                assertArrayEquals(expected3, TempDataStorage.getItem("18").getStringArrayFormat());
            }
        };

        initializerController.InitializeInventory();
    }
}
