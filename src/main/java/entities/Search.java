package entities;

import java.util.*;

public class Search {
    // Make sure you refactor to make it by the categories


    // figure out how to connect this part
    public ArrayList<Object> searchItem(String serialNumber){
        ArrayList<Object> searchedItem = new ArrayList<>();

        // return a data stucture instead that contains a boolean that denotes if the item was found
        // and the item at index 1.
        // Use temp data storage. has item and use get on temp data storage
        if (TempDataStorage.hasItem(serialNumber)){
            searchedItem.add(true);
            searchedItem.add(TempDataStorage.getItem(serialNumber));
            return searchedItem;}
        else {
            searchedItem.add(false);
            return searchedItem;}
        // How to properly handle case

    }

}
