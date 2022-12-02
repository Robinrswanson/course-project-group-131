package use_cases.sales_report;

import java.time.LocalDateTime;
import java.util.ArrayList;

public interface SalesReporterInputBoundary {
    /**
     * Generates a sales report with data in an external History file
     * @param startTime is the start time of the sales report
     * @param endTime is the end time of the sales report
     * @return an ArrayList of string arrays where each element of the list (a string array) is a row and each element
     * of the string array is a column in the sales report.
     */
    ArrayList<String[]> generateReport(LocalDateTime startTime, LocalDateTime endTime);
}
