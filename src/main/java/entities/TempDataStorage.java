package entities;

import java.util.*;

public class TempDataStorage {
    // Implemented using the Singleton Design Pattern
    private static Map<String, Item> inventory;

    private TempDataStorage(){}

    // changed this slightly (name from TempDataStorage -> setTempDataStorage)
    public static void setTempDataStorage(Map<String, Item> inventory_1) {
        inventory = inventory_1;
    }

    public static void addItem(Item new_item) {
        String serial_num = new_item.getName();
        inventory.put(serial_num, new_item);
    }

    public static Item getItem(String serial_num) {
        return inventory.get(serial_num);
    }

    // just in case it is possible to enter a wrong serial number
    public static boolean hasItem(String serialNum) {
        return inventory.containsKey(serialNum);
    }

    public static Map<String, Item> getInventory() {
        return inventory;
    }
}
