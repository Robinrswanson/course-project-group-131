package interface_adaptors.sales_report;


import java.util.ArrayList;

public interface SalesReporterView {
    String SALES_REPORT_SCREEN_NAME = "Sales Report";

    void setMessage(String message);
    void setTable(ArrayList<String[]> data);
}
