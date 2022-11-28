import java.io.IOException;
import java.util.*;

import entities.Item;
import entities.TempDataStorage;
import interface_adaptors.ImportPresenter;
import interface_adaptors.gatewayReader;
import use_cases.*;
public class Main{
    public static void main(String[] args) throws IOException {
        String file = "src\\main\\java\\Database\\Sample Data - Sample Item.csv";
        Map<String, Item> inventory = new HashMap<String, Item>();

        ImportPresenter presenter = new ImportPresenter();
        Import importer = new Import(presenter);
        gatewayReader reader = new gatewayReader(file);
        List<String[]> data2 = reader.getData();
        ImportDS data = new ImportDS(data2, file);
        data2.remove(0);

        for (String[] row: data2) {
            List<String> lst = new ArrayList<String>();
            Date date = new Date();
            Item item = new Item(row[1], Double.valueOf(row[2]), Integer.valueOf(row[3]), lst, date, "");
            inventory.put(row[0], item);
        }
        TempDataStorage.setTempDataStorage(inventory);

        Collection<Item> datalst = TempDataStorage.getInventory().values();
        for (Item item: datalst
        ) {
            System.out.println(item.getName() + ", " + item.getQuantity());
        }

        System.out.println("-----------------------");

        importer.importDatabase(data);
        Collection<Item> datalst2 = TempDataStorage.getInventory().values();
        for (Item item: datalst2
             ) {
            System.out.println(item.getName() + ", " + item.getQuantity());
        }
    }
}
