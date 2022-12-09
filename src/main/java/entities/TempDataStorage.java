package entities;

import java.util.*;

public class TempDataStorage {
    // Implemented using the Singleton Design Pattern
    private static Map<String, ItemInterface> inventory;

    private TempDataStorage(){}

    // changed this slightly (name from TempDataStorage -> setTempDataStorage)
    public static void setTempDataStorage(Map<String, ItemInterface> inventory_1) {
        inventory = inventory_1;
    }

    /**
     * Instantiates a new item to the inventory -> not used very much
     * @param new_item a new item
     */
    public static void addItem(ItemInterface new_item) {
        String serial_num = new_item.getName();
        inventory.put(serial_num, new_item);
    }

    public static ItemInterface getItem(String serial_num) {
        return inventory.get(serial_num);
    }

    // just in case it is possible to enter a wrong serial number
    public static boolean hasItem(String serialNum) {
        return inventory.containsKey(serialNum);
    }

    public static Map<String, ItemInterface> getInventory() {
        return inventory;
    }
}
