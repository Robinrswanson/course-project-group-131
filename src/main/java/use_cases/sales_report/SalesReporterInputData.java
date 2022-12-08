package use_cases.sales_report;

import entities.TempDataStorage;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class SalesReporterInputData {
    private final List<String[]> rows;
    private final LocalDateTime startTime;
    private final LocalDateTime endTime;
    private static final int DATE_TIME_COLUMN = 0;
    private static final int ACTION_COLUMN = 2;
    private static final int QUANTITY_COLUMN =  4;
    private static final int SERIAL_NUM_COLUMN = 5;

    /**
     * Instantiates a data object to carry the data required for the Sales Report use case
     * @param rows the rows of data from an external History file
     * @param startTime the user input startTime for the beginning of the sales report
     * @param endTime the user input endTime for the end of the sales report
     */
    public SalesReporterInputData(List<String[]> rows, String startTime, String endTime){
        this.rows = rows;
        this.startTime = stringToDateTime(startTime);
        this.endTime = stringToDateTime(endTime);
    }

    /**
     * Converts a dateTime string to a LocalDateTime object
     * @param dateTime a string in the format "yyyy-MM-dd HH:mm" representing date time
     * @return a LocalDateTime object
     */
    public static LocalDateTime stringToDateTime(String dateTime){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return LocalDateTime.parse(dateTime, formatter);
    }

    /**
     * Gets the startTime of the sales report
     * @return the startTime
     */
    public LocalDateTime getStartTime(){
        return startTime;
    }

    /**
     * Gets the endTime of the sales report
     * @return the endTime
     */
    public LocalDateTime getEndTime(){
        return endTime;
    }

    /**
     * Grabs the history data within the given time range
     * @return an ArrayList of string arrays representing the rows and columns of the history data
     */
    // split data into specified time range when given a list of string arrays in the format
    // [DateTime,Username,Action,Item Name,Quantity,Serial Number] and a startTime and endTime. The List is assumed to be in
    // chronological order.
    public ArrayList<String[]> splitListTimeRange() {
        ArrayList<String[]> result = new ArrayList<>();
        for (String[] row : rows) {
            LocalDateTime dateTime = stringToDateTime(row[DATE_TIME_COLUMN]);
            if (startTime.compareTo(dateTime) <= 0 && endTime.compareTo(dateTime) >= 0) {
                result.add(row);
            }
        }
        return result;
    }

    /**
     * Creates a list of unique serial numbers from the history data
     * @param rows rows of history data
     * @return a list of unique serial numbers that are within the given history data
     */
    // return a list of serial numbers representing all the unique items when given a list of string arrays in the format
    // [DateTime,Username,Action,Item Name,Quantity,Serial Number].
    public static ArrayList<String> serialNumList(ArrayList<String[]> rows){
        ArrayList<String> result = new ArrayList<>();
        for (String[] row: rows){
            if (!result.contains(row[SERIAL_NUM_COLUMN])){
                result.add(row[SERIAL_NUM_COLUMN]);
            }
        }
        return result;
    }

    public static String getName(String serialNum){
        return TempDataStorage.getItem(serialNum).getName();
    }

    /**
     * Returns the number of sales of a specific item within the history data
     * @param rows rows of history data
     * @param serialNum the serial number of the item
     * @return the number of items sold in the given history data
     */
    // return the number of items sold when given a list of string arrays in the
    // format [DateTime,Username,Action,Item Name,Quantity,Serial Number] and a string representing an item name.
    public static int getItemSold(ArrayList<String[]> rows, String serialNum){
        int quantity = 0;
        for (String[] row: rows){
            if (row[ACTION_COLUMN].equals("SELL ITEM") && row[SERIAL_NUM_COLUMN].equals(serialNum)){
                quantity += Integer.parseInt(row[QUANTITY_COLUMN]);
            }
        }
        return quantity;
    }

    /**
     * Returns the number of returns of a specific item within the history data
     * @param rows rows of history data
     * @param serialNum the serial number of the item
     * @return the number of items returned in the given history data
     */
    // return the number of items returned when given a list of string arrays in the
    // format [DateTime, Username, Action, Item Name, Quantity] and a string representing an item name.
    public static int getItemReturned(ArrayList<String[]> rows, String serialNum){
        int quantity = 0;
        for (String[] row: rows){
            if (row[ACTION_COLUMN].equals("RETURN ITEM") && row[SERIAL_NUM_COLUMN].equals(serialNum)){
                quantity += Integer.parseInt(row[QUANTITY_COLUMN]);
            }
        }
        return quantity;
    }

    /**
     * Returns the price of a specific item
     * @param serialNum the serial number of the item
     * @return the price of the item
     */
    //return a number representing the price of the item with the given serial number
    public static double getItemPrice(String serialNum){
        return TempDataStorage.getItem(serialNum).getPrice();
    }

    /**
     * Return the revenue of a specific item within the history data
     * @param rows rows of history data
     * @param serialNum the serial number of the item
     * @return the revenue in dollars of the item in the given history
     */
    // return the revenue when given an item's serial number and item name
    public static double getItemRevenue(ArrayList<String[]> rows, String serialNum){
        int quantity = getItemSold(rows, serialNum) - getItemReturned(rows, serialNum);
        Double price = getItemPrice(serialNum);
        return quantity*price;
    }

    /**
     * Return the total revenue of the store within the history data
     * @param rows rows of history data
     * @return the total revenue in dollars of the store
     */
    public static double getTotalRevenue(ArrayList<String[]> rows){
        List<String> serialNums = serialNumList(rows);
        double revenue = 0;
        for (String serialNum: serialNums){
            revenue += getItemRevenue(rows, serialNum);
        }
        return revenue;
    }

}
