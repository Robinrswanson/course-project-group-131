package show_history_use_case;
import java.time.LocalDateTime;
import java.util.List;

import show_history_use_case.ShowHistoryPresenter;
///Responseforamatter
//interface adapters
public class ShowHistoryFinalInput{
    String startdate;
    LocalDateTime startdatetime;
    LocalDateTime enddatetime;
    String enddate;
    String error;
    List<String[]> historydata;
    public ShowHistoryFinalInput(String start, String end){
        this.startdate = start;
        this.enddate = end;
        error = "";
    }
    public ShowHistoryFinalInput(String error){
        this.error = error;
        this.startdate = "";
        this.enddate = "";
    }
    public ShowHistoryFinalInput(String start,String end,List<String[]> historydata){
        this.startdate = start;
        this.enddate = end;
        this.historydata = historydata;
        this.error = "";
    }

    public String geterror(){
        return this.error;
    }


}
