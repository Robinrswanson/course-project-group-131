package use_cases.sales_report;
import entities.TempDataStorage;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


public class SalesReporter implements SalesReporterInputBoundary {
    private final SalesReporterOutputBoundary presenter;
    /*private final ShowHistoryDsGateway checker;*/
    private final int DATE_TIME_COLUMN = 0;
    private final int ACTION_COLUMN = 2;
    private final int QUANTITY_COLUMN =  4;
    private final int SERIAL_NUM_COLUMN = 5;

    public SalesReporter(SalesReporterOutputBoundary presenter, ShowHistoryDsGateway checker) {
        this.presenter = presenter;
        this.checker = checker;
    }

    // return a list of string arrays representing where each element in the list is a row in the sales report, and each
    // element in the array is a column of that row.
    public void generateReport(List<String[]> rows, String startTime, String endTime){
        LocalDateTime start = stringToDateTime(startTime);
        LocalDateTime end = stringToDateTime(endTime);
        if (!checker.StartDateValid(start)){
            presenter.prepareFailure(SalesReporterOutputBoundary.START_TIME_ERROR);
        }
        else if (!checker.EndDateValid(end)){
            presenter.prepareFailure(SalesReporterOutputBoundary.END_TIME_ERROR);
        }
        else {
            ArrayList<String[]> splitData = splitListTimeRange(rows, start, end);
            ArrayList<String> serialNumList = serialNumList(splitData);
            ArrayList<String[]> result = new ArrayList<String[]>();
            for (String serialNum : serialNumList) {
                result.add(getRow(splitData, serialNum));
            }
            String totalRevenue = String.format("Total Revenue: $%.5f", totalRevenue(splitData));
            result.add(new String[]{"", "", "", "", "", totalRevenue});
            presenter.prepareSuccess(result);
        }
    }
    // probably should have this somewhere else so that the History use case can also use it idk?
    public LocalDateTime stringToDateTime(String dateTime){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime result = LocalDateTime.parse(dateTime);
        return result;
    }

    public String[] getRow (ArrayList<String[]> rows, String serialNum){
        String name = TempDataStorage.getItem(serialNum).getName();
        String price = String.valueOf(itemPrice(serialNum));
        String quantitySold = String.valueOf(itemSold(rows, serialNum));
        String quantityReturned = String.valueOf(itemReturned(rows, serialNum));
        String revenue = String.valueOf(itemRevenue(rows, serialNum));
        return new String[]{serialNum, name, price, quantitySold, quantityReturned, revenue};
    }

    // split data into specified time range when given a list of string arrays in the format
    // [DateTime,Username,Action,Item Name,Quantity] and a startTime and endTime. The List is assumed to be in
    // chronological order.
    public ArrayList<String[]> splitListTimeRange(List<String[]> rows, LocalDateTime startTime, LocalDateTime endTime){
        ArrayList<String[]> result= new ArrayList<>();
        for (String[] row: rows){
            LocalDateTime dateTime = stringToDateTime(row[DATE_TIME_COLUMN]);
            if (startTime.compareTo(dateTime) <= 0 && endTime.compareTo(dateTime) >= 0){
                result.add(row);
            }
        }
        return result;
    }
    // return a list of serial numbers representing all the unique items when given a list of string arrays in the format
    // [DateTime,Username,Action,Item Name,Quantity].
    public ArrayList<String> serialNumList(ArrayList<String[]> rows){
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
    public int itemSold(ArrayList<String[]> rows, String serialNum){
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
    public int itemReturned(ArrayList<String[]> rows, String serialNum){
        int quantity = 0;
        for (String[] row: rows){
            if (row[ACTION_COLUMN].equals("RETURN ITEM") && row[SERIAL_NUM_COLUMN].equals(serialNum)){
                quantity += Integer.parseInt(row[QUANTITY_COLUMN]);
            }
        }
        return quantity;
    }
    //return a number representing the price of the item with the given serial number
    public Double itemPrice(String serialNum){
        return TempDataStorage.getItem(serialNum).getPrice();
    }
    // return the revenue when given an item's serial number and item name
    public double itemRevenue(ArrayList<String[]> rows, String serialNum){
        int quantity = itemSold(rows, serialNum) - itemReturned(rows, serialNum);
        int price = (int) TempDataStorage.getItem(serialNum).getPrice();
        return quantity*price;
    }

    public double totalRevenue(ArrayList<String[]> rows){
        List<String> serialNums = serialNumList(rows);
        double revenue = 0;
        for (String serialNum: serialNums){
            revenue += itemRevenue(rows, serialNum);
        }
        return revenue;
    }

}
