package use_cases.sales_report;

import entities.TempDataStorage;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class SalesReporterInputData {
    private List<String[]> rows;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private static final int DATE_TIME_COLUMN = 0;
    private static final int ACTION_COLUMN = 2;
    private static final int QUANTITY_COLUMN =  4;
    private static final int SERIAL_NUM_COLUMN = 5;

    public SalesReporterInputData(List<String[]> rows, String startTime, String endTime){
        this.rows = rows;
        this.startTime = stringToDateTime(startTime);
        this.endTime = stringToDateTime(endTime);
    }
    public static LocalDateTime stringToDateTime(String dateTime){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return LocalDateTime.parse(dateTime, formatter);
    }
    public LocalDateTime getStartTime(){
        return startTime;
    }
    public LocalDateTime getEndTime(){
        return endTime;
    }

    // split data into specified time range when given a list of string arrays in the format
    // [DateTime,Username,Action,Item Name,Quantity] and a startTime and endTime. The List is assumed to be in
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
    // return a list of serial numbers representing all the unique items when given a list of string arrays in the format
    // [DateTime,Username,Action,Item Name,Quantity].
    public static ArrayList<String> serialNumList(ArrayList<String[]> rows){
        ArrayList<String> result = new ArrayList<>();
        for (String[] row: rows){
            if (!result.contains(row[SERIAL_NUM_COLUMN])){
                result.add(row[SERIAL_NUM_COLUMN]);
            }
        }
        return result;
    }
    // return the number of items sold when given a list of string arrays in the
    // format [DateTime,Username,Action,Item Name,Quantity] and a string representing an item name.
    public static int itemSold(ArrayList<String[]> rows, String serialNum){
        int quantity = 0;
        for (String[] row: rows){
            if (row[ACTION_COLUMN].equals("SELL ITEM") && row[SERIAL_NUM_COLUMN].equals(serialNum)){
                quantity += Integer.parseInt(row[QUANTITY_COLUMN]);
            }
        }
        return quantity;
    }
    // return the number of items returned when given a list of string arrays in the
    // format [DateTime, Username, Action, Item Name, Quantity] and a string representing an item name.
    public static int itemReturned(ArrayList<String[]> rows, String serialNum){
        int quantity = 0;
        for (String[] row: rows){
            if (row[ACTION_COLUMN].equals("RETURN ITEM") && row[SERIAL_NUM_COLUMN].equals(serialNum)){
                quantity += Integer.parseInt(row[QUANTITY_COLUMN]);
            }
        }
        return quantity;
    }
    //return a number representing the price of the item with the given serial number
    public static Double itemPrice(String serialNum){
        return TempDataStorage.getItem(serialNum).getPrice();
    }

    // return the revenue when given an item's serial number and item name
    public static double itemRevenue(ArrayList<String[]> rows, String serialNum){
        int quantity = itemSold(rows, serialNum) - itemReturned(rows, serialNum);
        int price = (int) TempDataStorage.getItem(serialNum).getPrice();
        return quantity*price;
    }
    public static double totalRevenue(ArrayList<String[]> rows){
        List<String> serialNums = serialNumList(rows);
        double revenue = 0;
        for (String serialNum: serialNums){
            revenue += itemRevenue(rows, serialNum);
        }
        return revenue;
    }

}
