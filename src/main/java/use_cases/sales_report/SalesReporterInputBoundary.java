package use_cases.sales_report;

public interface SalesReporterInputBoundary {
    /**
     * Generates a sales report with data in an external History file
     * @param rows is the data that is read from an external History file
     * @param startTime is the start time of the sales report
     * @param endTime is the end time of the sales report
     */
    void generateReport(SalesReporterInputData data);
}
