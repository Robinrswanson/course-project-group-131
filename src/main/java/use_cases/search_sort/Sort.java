package use_cases.search_sort;

import entities.Item;
import entities.TempDataStorage;
import java.text.ParseException;
import java.util.*;
import java.text.SimpleDateFormat;
public class Sort implements SortInputBoundary{
    private final SortOutputBoundary presenter;
    private final Collection<Item> inventory;

    /**
     *
     * @param presenter this takes in the SortPresenter
     */
    public Sort(SortOutputBoundary presenter){
        this.presenter = presenter;
        this.inventory = TempDataStorage.getInventory().values();
    }

    /**
     * The Sort use case. Once it executes, it tells the presenter to update the information
     * @param parameter is a list of strings that contain the parameters to be used in the search
     * The value at index 0 denotes the type
     * The value at index 1 is the condition that will be sued for the sort
     * The value at index 2 is the parameter to be used for the sort (higher, lower, or equal)
     */
    public void executeSort(String[] parameter) throws ParseException {
        ArrayList<Item> returnItem = new ArrayList<>();
            for (Item currItem: inventory) {
                if (Objects.equals(parameter[0], "name"))
                    extractedName(Objects.equals(currItem.getName(), parameter[1]), returnItem, currItem);
                else if (Objects.equals(parameter[0], "storageLocation"))
                    extractedStorageLocation(Objects.equals(currItem.getStorageLocation(), parameter[1]), returnItem, currItem);
                if (Objects.equals(parameter[2], "equal"))
                    {extractedEqual(returnItem, parameter, currItem);}
                else if (Objects.equals(parameter[2], "higher"))
                    {extractedHigher(returnItem, parameter, currItem);}
                else if (Objects.equals(parameter[2], "lower"))
                    {extractedLower(returnItem, parameter, currItem);}
            }

        presenter.prepareSuccess(returnItem);}

    /**
     *
     * @param currItem this is the boolean that denotes whether or not the items match
     * @param returnItem this is the list of items to be returned at the end of the sort
     * @param currItem1 this is the current item that is being checked
     */
    private static void extractedName(boolean currItem, ArrayList<Item> returnItem, Item currItem1) {
        if (currItem){
            if (!returnItem.contains(currItem1)){
            returnItem.add(currItem1);}
        }
    }
    /**
     *
     * @param currItem this is the boolean that denotes whether or not the items match
     * @param returnItem this is the list of items to be returned at the end of the sort
     * @param currItem1 this is the current item that is being checked
     */
    private static void extractedStorageLocation(boolean currItem, ArrayList<Item> returnItem, Item currItem1) {
        if (currItem){
            if (!returnItem.contains(currItem1)){
                returnItem.add(currItem1);}}
    }

    private static void extractedEqual(ArrayList<Item> returnItem, String[] parameter, Item currItem) throws ParseException {
        // This takes into account teh case where the search condition is "equal"
        if ((Objects.equals(parameter[0], "price"))) {
            double check = Double.parseDouble(parameter[1]);
            if (currItem.getPrice() == check){
                if (!returnItem.contains(currItem)){
                    returnItem.add(currItem);}
        }
    } else if ((Objects.equals(parameter[0], "quantity"))) {
        int check = Integer.parseInt(parameter[1]);
        if (currItem.getQuantity() == check){
            if (!returnItem.contains(currItem)){
                returnItem.add(currItem);}}
    }  else if ((Objects.equals(parameter[0], "expirationDate"))) {
                Date check = new SimpleDateFormat("dd/MM/yyyy").parse(parameter[1]);
                if (currItem.getExpirationDates().compareTo(check) == 0){
                    if (!returnItem.contains(currItem)){
                        returnItem.add(currItem);}}
                }
    }
    //TODO come back to this part

    private static void extractedHigher(ArrayList<Item> returnItem, String[] parameter, Item currItem) throws ParseException {
        if ((Objects.equals(parameter[0], "price"))) {
            double check = Double.parseDouble(parameter[1]);
            if (currItem.getPrice() > check){
                if (!returnItem.contains(currItem)){
                    returnItem.add(currItem);}
            }
        } else if ((Objects.equals(parameter[0], "quantity"))) {
            int check = Integer.parseInt(parameter[1]);
            if (currItem.getQuantity() > check){
                if (!returnItem.contains(currItem)){
                    returnItem.add(currItem);}}
        }  else if ((Objects.equals(parameter[0], "expirationDate"))) {
            Date check = new SimpleDateFormat("dd/MM/yyyy").parse(parameter[1]);
            if (currItem.getExpirationDates().compareTo(check) > 0)
                if (!returnItem.contains(currItem)){
                    returnItem.add(currItem);}}
    }

    private static void extractedLower(ArrayList<Item> returnItem, String[] parameter, Item currItem) throws ParseException {
        if ((Objects.equals(parameter[0], "price"))) {
            double check = Double.parseDouble(parameter[1]);
            if (currItem.getPrice() < check){
                if (!returnItem.contains(currItem)){
                    returnItem.add(currItem);}
            }
        } else if ((Objects.equals(parameter[0], "quantity"))) {
            int check = Integer.parseInt(parameter[1]);
            if (currItem.getQuantity() < check){
                if (!returnItem.contains(currItem)){
                    returnItem.add(currItem);}}
        }  else if ((Objects.equals(parameter[0], "expirationDate"))) {
            Date check = new SimpleDateFormat("dd/MM/yyyy").parse(parameter[1]);
            if (currItem.getExpirationDates().compareTo(check) < 0)
                if (!returnItem.contains(currItem)){
                    returnItem.add(currItem);}}
    }
    // Loop over input list of parameters to get the search types and values


        }

