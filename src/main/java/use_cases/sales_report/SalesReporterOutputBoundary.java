package use_cases.sales_report;

import interface_adaptors.sales_report.SalesReporterView;

import java.util.ArrayList;

public interface SalesReporterOutputBoundary {
    int START_TIME_ERROR = 0; // error code for invalid start time
    int END_TIME_ERROR = 1; // error code for invalid end time
    void setScreen(SalesReporterView screen);
    void prepareSuccess(ArrayList<String[]> data); // display for a successful report
    void prepareFailure(int error); // display for unsuccessful report
}
