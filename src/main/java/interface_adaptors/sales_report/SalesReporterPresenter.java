package interface_adaptors.sales_report;

import use_cases.sales_report.SalesReporterOutputBoundary;

import java.util.ArrayList;

public class SalesReporterPresenter implements SalesReporterOutputBoundary {

    SalesReporterView screen;

    public void setScreen(SalesReporterView screen){this.screen = screen;}

    /**
     * Called if date entry is successful
     * @param data contains a data structure representing the rows and columns of the sales report
     */
    @Override
    public void prepareSuccess(ArrayList<String[]> data){
        screen.setMessage("");
        screen.setTable(data);
    }

    /**
     * Called if date entry is unsuccessful
     * @param error the error code
     */
    @Override
    public void prepareFailure(int error){
        String message = null;

        if (error == START_TIME_ERROR){
            message = "Error: Start time is set too early";
        }
        else if (error == END_TIME_ERROR) {
            message = "Error: End time is set too late";
        }
        screen.setMessage(message);
    }
}
