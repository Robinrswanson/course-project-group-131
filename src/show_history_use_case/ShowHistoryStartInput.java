package show_history_use_case;
import java.util.Date;
//history date has limit
public class ShowHistoryStartInput {
    private String startdate;
    private String enddate;

    public ShowHistoryStartInput(String start, String end){
        this.startdate = start;
        this.enddate = end;
    }
    //getters here could be removed if we want to make code less and easy
    String getStartdate(){return startdate;}
    String getEnddate(){return enddate;}
    //we might need setters
}
