package interface_adaptors.show_history;

import use_cases.show_history_use_case.ShowHistoryInputBoundary;
import use_cases.show_history_use_case.ShowHistoryResponseModel;
import use_cases.show_history_use_case.ShowHistoryStartInput;

import java.io.IOException;

public class ShowHistoryController {
    private ShowHistoryInputBoundary inputboundary;

    public ShowHistoryController(ShowHistoryInputBoundary boundary){
        this.inputboundary= boundary;}
    public ShowHistoryResponseModel show(String startdate, String enddate) throws IOException {
        ShowHistoryStartInput startinput = new ShowHistoryStartInput(startdate,enddate);
        return inputboundary.show(startinput);
    }
}
