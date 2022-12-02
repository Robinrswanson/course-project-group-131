package entities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Date;


public class Sort {
    // Use a factory design pattern to make the different strategies
    private final List<Object> searchParameters;
    private final Collection<Item> inventory;


    public Sort(List<Object> searchParameters){
        this.inventory = TempDataStorage.getInventory().values();
        this.searchParameters = searchParameters;
        // searchParameter is a list of list where the inner list contains a string at index 0 that denotes the type
        // and a value at index 1 to be used for the search
        // and a value at index 2 to be used for the search (higher, lower, or equal)
        // Consider changing the list to a class
        // Could be extended to find ranges by having a class that finds the overlap between higher and lower. 
    }

    public ArrayList<Item> executeSort(){
        // This function executes a sort based on the given parameters and conditions.
        ArrayList<Item> returnItem = new ArrayList<>();
        for (Object parameter: searchParameters){
            for (Item currItem: inventory) {
                if (((List<?>) parameter).get(0) == "name")
                    extractedName(currItem.getName() == ((List<?>) parameter).get(1), returnItem, currItem);
                else if ((((List<?>) parameter).get(0) == "storageLocation"))
                    extractedStorageLocation(currItem.getStorageLocation() == ((List<?>) parameter).get(1), returnItem, currItem);
                if ((((List<?>) parameter).get(2) == "equal"))
                    {extractedEqual(returnItem, (List<?>) parameter, currItem);}
                else if ((((List<?>) parameter).get(2) == "higher"))
                    {extractedHigher(returnItem, (List<?>) parameter, currItem);}
                else if ((((List<?>) parameter).get(2) == "lower"))
                    {extractedLower(returnItem, (List<?>) parameter, currItem);}
            }}

        return returnItem;}

    private static void extractedName(boolean currItem, ArrayList<Item> returnItem, Item currItem1) {
        if (currItem){
            if (!returnItem.contains(currItem1)){
            returnItem.add(currItem1);}
        }
    }

    private static void extractedStorageLocation(boolean currItem, ArrayList<Item> returnItem, Item currItem1) {
        // This needs to check the condition (higher, lower, or equal)
        if (currItem){
            // There could be a problem here with comparing dates
            if (!returnItem.contains(currItem1)){
                returnItem.add(currItem1);}}
    }

    private static void extractedEqual(ArrayList<Item> returnItem, List<?> parameter, Item currItem) {
        // This takes into account teh case where the search condition is "equal"
        if ((parameter.get(0) == "price")) {
        // This needs to check the condition (higher, lower, or equal)
            if (currItem.getPrice() == (double)(parameter.get(1))){
                if (!returnItem.contains(currItem)){
                    returnItem.add(currItem);}
        }
    } else if ((parameter.get(0) == "quantity")) {
        // This needs to check the condition (higher, lower, or equal)
        if (currItem.getQuantity() == (int)(parameter.get(1))){
            if (!returnItem.contains(currItem)){
                returnItem.add(currItem);}}
    }  else if ((parameter.get(0) == "expirationDate")) {
                if (currItem.getExpirationDates() == parameter.get(1)){
                    if (!returnItem.contains(currItem)){
                        returnItem.add(currItem);}}
                }
    }

    private static void extractedHigher(ArrayList<Item> returnItem, List<?> parameter, Item currItem) {
        // This takes into account teh case where the search condition is "higher"
        if ((parameter.get(0) == "price")) {
            // This needs to check the condition (higher, lower, or equal)
            if (currItem.getPrice() > (double)(parameter.get(1))){
                if (!returnItem.contains(currItem)){
                    returnItem.add(currItem);}
            }
        } else if ((parameter.get(0) == "quantity")) {
            // This needs to check the condition (higher, lower, or equal)
            if (currItem.getQuantity() > (int)(parameter.get(1))){
                if (!returnItem.contains(currItem)){
                    returnItem.add(currItem);}}
        }  else if ((parameter.get(0) == "expirationDate")) {
            if (currItem.getExpirationDates() == parameter.get(1))
                // need to figure out how to fix this
                //
                //
                if (!returnItem.contains(currItem)){
                    returnItem.add(currItem);}}
    }

    private static void extractedLower(ArrayList<Item> returnItem, List<?> parameter, Item currItem) {
        // This takes into account teh case where the search condition is "higher"
        if ((parameter.get(0) == "price")) {
            // This needs to check the condition (higher, lower, or equal)
            if (currItem.getPrice() < (double)(parameter.get(1))){
                if (!returnItem.contains(currItem)){
                    returnItem.add(currItem);}
            }
        } else if ((parameter.get(0) == "quantity")) {
            // This needs to check the condition (higher, lower, or equal)
            if (currItem.getQuantity() < (int)(parameter.get(1))){
                if (!returnItem.contains(currItem)){
                    returnItem.add(currItem);}}
        }  else if ((parameter.get(0) == "expirationDate")) {
            if (currItem.getExpirationDates() == parameter.get(1))
                // need to figure out how to fix this
                //
                //
                if (!returnItem.contains(currItem)){
                    returnItem.add(currItem);}}
    }
    // Loop over input list of parameters to get the search types and values


        }

