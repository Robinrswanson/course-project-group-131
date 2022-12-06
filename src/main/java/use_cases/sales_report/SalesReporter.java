package use_cases.sales_report;
import entities.TempDataStorage;

import java.time.LocalDateTime;
import java.util.ArrayList;



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
    public void generateReport(SalesReporterInputData data){
        LocalDateTime start = data.getStartTime();
        LocalDateTime end = data.getEndTime();
        if (!checker.StartDateValid(start)){
            presenter.prepareFailure(SalesReporterOutputBoundary.START_TIME_ERROR);
        }
        else if (!checker.EndDateValid(end)){
            presenter.prepareFailure(SalesReporterOutputBoundary.END_TIME_ERROR);
        }
        else {
            ArrayList<String[]> splitData = data.splitListTimeRange();
            ArrayList<String> serials = SalesReporterInputData.serialNumList(splitData);
            ArrayList<String[]> result = new ArrayList<String[]>();
            for (String serialNum : serials) {
                result.add(getRow(splitData, serialNum));
            }
            String totalRevenue = String.format("Total Revenue: $%.5f", SalesReporterInputData.totalRevenue(splitData));
            result.add(new String[]{"", "", "", "", "", totalRevenue});
            presenter.prepareSuccess(result);
        }
    }

    public String[] getRow (ArrayList<String[]> rows, String serialNum){
        String name = TempDataStorage.getItem(serialNum).getName();
        String price = String.valueOf(SalesReporterInputData.itemPrice(serialNum));
        String quantitySold = String.valueOf(SalesReporterInputData.itemSold(rows, serialNum));
        String quantityReturned = String.valueOf(SalesReporterInputData.itemReturned(rows, serialNum));
        String revenue = String.valueOf(SalesReporterInputData.itemRevenue(rows, serialNum));
        return new String[]{serialNum, name, price, quantitySold, quantityReturned, revenue};
    }
}
