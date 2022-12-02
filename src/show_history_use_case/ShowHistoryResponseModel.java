package show_history_use_case;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

///Responseforamatter
//interface adapters
public class ShowHistoryResponseModel {
    String startdate;
    LocalDateTime startdatetime;
    LocalDateTime enddatetime;
    String enddate;
    String error;
    ArrayList<String[]>historydata;
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
    public ShowHistoryResponseModel(String start, String end, ArrayList<String[]> historydata){
        this.startdate = start;
        this.enddate = end;
        this.historydata = historydata;
        this.error = "";
    }

    public String geterror(){
        return this.error;
    }

    public ArrayList<String[]> gethistorydata() {
        return this.historydata;
    }


}
