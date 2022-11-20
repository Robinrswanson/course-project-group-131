package history_screens;

import show_history_use_case.ShowHistoryFinalInput;
import show_history_use_case.ShowHistoryInputBoundary;
import show_history_use_case.ShowHistoryStartInput;

public class ShowHistoryController {
    final ShowHistoryInputBoundary inputboundary;

    public ShowHistoryController(ShowHistoryInputBoundary boundary){
        this.inputboundary= boundary;}
        ShowHistoryFinalInput show(String startdate, String enddate){
            ShowHistoryStartInput startinput = new ShowHistoryStartInput(startdate,enddate);
            return inputboundary.show(startinput);
    }
}
