package use_cases.initializer;

import entities.Item;
import entities.TempDataStorage;
import use_cases.gateway_interfaces.Temporary;

import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

public class InitializeUseCase implements InitializerInputBoundary {

    public InitializeUseCase(){
    }

    /**
     * Initializes TempDataStorage based on the database
     * @param reader a GatewayReader that reads the database and returns its contents in a List
     */
    @Override
    public void initializeInventory(Temporary reader) throws ParseException, IOException {
        InitializerDS database = new InitializerDS(reader.getData());
        Map<String, Item> inventory = new HashMap<>();
        for (String[] row: database.getInventory()
             ) {
            Item item = new Item(row);
            inventory.put(row[0], item);
        }
        TempDataStorage.setTempDataStorage(inventory);
    }
}
