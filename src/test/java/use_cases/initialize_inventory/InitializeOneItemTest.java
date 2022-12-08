package use_cases.initialize_inventory;

import entities.TempDataStorage;
import interface_adaptors.gateway.GatewayReader;
import interface_adaptors.inventory_initializer.InitializerController;
import org.junit.jupiter.api.Test;
import use_cases.initializer.InitializeUseCase;

import java.io.IOException;
import java.text.ParseException;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class InitializeOneItemTest {
    @Test
    void create() throws ParseException, IOException {
        InitializerController initializerController = new InitializerController() {
            @Override
            public void InitializeInventory() throws ParseException, IOException {
                GatewayReader reader = new GatewayReader("src/test/java/TestingSampleData/Single Item.csv");
                InitializeUseCase initializer = new InitializeUseCase(); //Creates the use case
                initializer.initializeInventory(reader); //Calls inventory initializer method

                String[] expected1 = {"1", "Ice Cream", "9.99", "10", "N/A", "N/A", "Frozen"};
                assertArrayEquals(expected1, TempDataStorage.getItem("1").getStringArrayFormat());
                Set<String> expected2 = new HashSet<>();
                expected2.add("1");
                assertEquals(expected2, TempDataStorage.getInventory().keySet());
            }
        };

        initializerController.InitializeInventory();
    }
}
