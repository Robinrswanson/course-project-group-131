package use_cases.initialize_inventory;

import entities.Item;
import entities.TempDataStorage;
import interface_adaptors.gateway.GatewayReader;
import interface_adaptors.inventory_initializer.InitializerController;
import org.junit.jupiter.api.Test;
import use_cases.initializer.InitializeUseCase;

import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class InitializeNoItemsTest {
    @Test
    void create() throws ParseException, IOException {
        InitializerController initializerController = new InitializerController() {
            @Override
            public void InitializeInventory() throws ParseException, IOException {
                GatewayReader reader = new GatewayReader("src/test/java/TestingSampleData/No Items.csv");
                InitializeUseCase initializer = new InitializeUseCase(); //Creates the use case
                initializer.initializeInventory(reader); //Calls inventory initializer method

                Map<String, Item> expected = new HashMap<>();
                assertEquals(expected, TempDataStorage.getInventory());
            }
        };

        initializerController.InitializeInventory();
    }
}

