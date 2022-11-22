package use_cases;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;


public class SalesReporter {
    public List<String[]> generateReport(LocalDateTime startTime, LocalDateTime endTime){
        return;
    }

    // split data into specified time range when given a list of string arrays in the format
    // [DateTime, Username, Action, Item Name, Quantity] and a startTime and endTime. The List is assumed to be in
    // chronological order.
    public List<String[]> splitListTimeRange(List<String[]> rows, LocalDateTime startTime, LocalDateTime endTime){
        List <String[]> result = null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        for (String[] row: rows){
            LocalDateTime dateTime = LocalDateTime.parse(row[0], formatter);
            if (startTime.compareTo(dateTime) <= 0 && endTime.compareTo(dateTime) >= 0){
                result.add(row);
            }
        }
        return result;
    }
    // return a list of strings representing all the unique items when given a list of string arrays in the format
    // [DateTime, Username, Action, Item Name, Quantity].
    public List<String> itemsList(List<String[]> rows){
        List<String> result = null;
        for (String[] row: rows){
            if (!result.contains(row[3])){
                result.add(row[3]);
            }
        }
        return result;
    }
    // return the number of items sold when given a list of string arrays in the
    // format [DateTime, Username, Action, Item Name, Quantity] and a string representing an item name.
    public int itemsSold(List<String[]> rows, String item){
        int quantity = 0;
        for (String[] row: rows){
            if (row[2].equals("SELL ITEM") && row[3].equals(item)){
                quantity += Integer.parseInt(row[4]);
            }
        }
        return quantity;
    }
    // return the number of items returned when given a list of string arrays in the
    // format [DateTime, Username, Action, Item Name, Quantity] and a string representing an item name.
    public int itemsReturned(List<String[]> rows, String item){
        int quantity = 0;
        for (String[] row: rows){
            if (row[2].equals("RETURN ITEM") && row[3].equals(item)){
                quantity += Integer.parseInt(row[4]);
            }
        }
        return quantity;
    }
    public double itemRevenue(List<String[]> rows, String item){
        int quantity = itemsSold(rows, item) - itemsReturned(rows,item);
        return quantity;
    }

}
