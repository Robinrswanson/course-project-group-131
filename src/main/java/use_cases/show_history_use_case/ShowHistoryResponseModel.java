package use_cases.show_history_use_case;
import java.time.LocalDateTime;

///Responseforamatter
//interface adapters
public class ShowHistoryResponseModel {
    String startdate;
    LocalDateTime startdatetime;
    LocalDateTime enddatetime;
    String enddate;
    String error;
    String[][] historydata;
    public ShowHistoryResponseModel(String start, String end){
        this.startdate = start;
        this.enddate = end;
        error = "";
    }
    public ShowHistoryResponseModel(String error){
        this.error = error;
        this.startdate = "";
        this.enddate = "";
    }
    public ShowHistoryResponseModel(String start, String end, String[][] historydata){
        this.startdate = start;
        this.enddate = end;
        this.historydata = historydata;
        this.error = "";
    }

    public String geterror(){
        return this.error;
    }

    public String[][] gethistorydata() {
        return this.historydata;
    }


}
