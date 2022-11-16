package history_use_case;
import java.util.Date;
//history date has limit
public class ShowHistoryStartInput {
    private Date startdate;
    private Date enddate;

    public ShowHistoryStartInput(Date start, Date end){
        this.startdate = start;
        this.enddate = end;
    }
}
