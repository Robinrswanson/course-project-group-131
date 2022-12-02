package use_cases.initializer;

import entities.Item;
import entities.TempDataStorage;
import use_cases.gateway_interfaces.GatewayReaderInterface;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class InitializeUseCase implements InitializerInputBoundary {

    public InitializeUseCase(){
    }

    /**
     * Initializes TempDataStorage based on the database
     * @param reader a GatewayReader that reads the database and returns its contents in a List
     */
    @Override
    public void initializeInventory(GatewayReaderInterface reader) throws ParseException, IOException {
        InitializerDS database = new InitializerDS(reader.getData());
        Map<String, Item> inventory = new HashMap<>();
        for (String[] row: database.getInventory()
             ) {
            //Change depending on how categories are formatted in database
            List<String> categories = new ArrayList<>(Arrays.asList(row[4].split(";")));
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date date = dateFormat.parse(row[5]);
            Item item = new Item(row[0], row[1], Double.parseDouble(row[2]), Integer.parseInt(row[3]), categories, date, row[6]);
            inventory.put(row[0], item);
        }
        TempDataStorage.setTempDataStorage(inventory);
    }
}
