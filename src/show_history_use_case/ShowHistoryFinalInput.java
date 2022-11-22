package show_history_use_case;
///Responseforamatter
import show_history_use_case.ShowHistoryPresenter;
//interface adapters
public class ShowHistoryFinalInput{
    String startdate;
    String enddate;
    String error;
    public ShowHistoryFinalInput(String start, String end){
        this.startdate = start;
        this.enddate = end;
        error = "";
    }
    public ShowHistoryFinalInput(String error){
        this.error = error;
    }


}
