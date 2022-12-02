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

    @Override
    public void initializeInventory(GatewayReaderInterface reader) throws ParseException, IOException {
        InitializerDS database = new InitializerDS(reader.getData());
        Map<String, Item> inventory = new HashMap<>();
        for (String[] row: database.getInventory()
             ) {
            List<String> categories = new ArrayList<>();
            for (String category: row[4].split(";") //Change depending on how categories are formatted in database
                 ) {
                categories.add(category);
            }
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date date = dateFormat.parse(row[5]);
            Item item = new Item(row[0], row[1], Double.valueOf(row[2]), Integer.valueOf(row[3]), categories, date, row[6]);
            inventory.put(row[0], item);
        }
        TempDataStorage.setTempDataStorage(inventory);
    }
}
