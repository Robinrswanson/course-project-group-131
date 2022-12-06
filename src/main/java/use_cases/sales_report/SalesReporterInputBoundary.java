package use_cases.sales_report;

public interface SalesReporterInputBoundary {
    /**
     * Generates a sales report with data in an external History file
     * @param data contains the rows of data from the external History file along with a user input startTime and endTime
     */
    void generateReport(SalesReporterInputData data);
}
