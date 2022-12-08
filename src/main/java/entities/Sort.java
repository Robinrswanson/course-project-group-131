package entities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Date;


public class Sort {
    // This can be the context for the sort strategy discuss with group
    private List<Object> searchParameters;
    private Collection<Item> inventory;


    public Sort(List<Object> searchParameters){
        // Get rig of the strategies
        this.inventory = TempDataStorage.getInventory().values();
        this.searchParameters = searchParameters;
        // searchParameter is a list of list where the inner list contains a string at index 0 that denotes the type
        // and a value at index 1 to be used for the search
    }

    public ArrayList<Item> executeSort(){
        ArrayList<Item> returnItem = new ArrayList<Item>();
        // You can refactor this to only loop over once
        // Make an object parameter
        for (Object parameter: searchParameters){
            for (Item currItem: inventory) {
                // could use switch instead / other implmentation
                if ((String)(((List) parameter).get(0)) == "name") {
                    if (currItem.getName() == (String)(((List) parameter).get(1))){
                        returnItem.add(currItem);
                    }
                }
                else if (((String)(((List) parameter).get(0)) == "price")) {
                    // Need to take into account lower and higher and or equal
                    if (currItem.getPrice() >= (double)(((List) parameter).get(1))){
                        returnItem.add(currItem);
                    }
                } else if (((String)(((List) parameter).get(0)) == "quantity")) {
                    if (currItem.getQuantity() >= (int)(((List) parameter).get(1))){
                        returnItem.add(currItem);}
                } else if (((String)(((List) parameter).get(0)) == "expirationDate")) {
                        if (currItem.getExpirationDates() == (Date)(((List) parameter).get(1))){
                            returnItem.add(currItem);}
                } else if (((String)(((List) parameter).get(0)) == "storageLocation")) {
                            if (currItem.getStorageLocation() == (String)(((List) parameter).get(1))){
                                returnItem.add(currItem);
                            }
                        }

            }

        }
        // Loop over input list of parameters to get the search types and values


        return returnItem;}
}
