package entities;

import java.util.*;

public class Search implements Searchable{
    // Make sure you refactor to make it by the categories
    String serialNumber;

    // figure out how to connent this part
    public Search(String serialNumber){
    this.serialNumber = serialNumber;
    }
    public ArrayList<Object> searchItem(){
        ArrayList<Object> searchedItem = new ArrayList<>();

        // return a data stucture instead that contains a boolean that denotes if the item was found
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
