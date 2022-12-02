package history_screens;

import show_history_use_case.ShowHistoryResponseModel;
import show_history_use_case.ShowHistoryInputBoundary;
import show_history_use_case.ShowHistoryStartInput;

import java.io.IOException;

public class ShowHistoryController {
    final ShowHistoryInputBoundary inputboundary;

    public ShowHistoryController(ShowHistoryInputBoundary boundary){
        this.inputboundary= boundary;}
    public static ShowHistoryResponseModel show(String startdate, String enddate) throws IOException {
        ShowHistoryStartInput startinput = new ShowHistoryStartInput(startdate,enddate);
        return inputboundary.show(startinput);
    }
}
