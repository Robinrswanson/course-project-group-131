import java.util.*;

public class TempDataStorage {
    private static Map<String, Item> inventory;

    public static void TempDataStorage(Map<String, Item> inventory_1){
        inventory = inventory_1;
    }

    public static void addItem(Item new_item) {
        String serial_num = new_item.getName();
        inventory.put(serial_num, new_item);
    }

    public static Item getItem(String serial_num) {
        return inventory.get(serial_num);
    }

    public static Map<String, Item> getInventory(){
        return inventory;
    }
}
