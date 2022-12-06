package use_cases.show_history_use_case;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

//history date has limit
public class ShowHistoryStartInput {
    private String startdate;
    private String enddate;

    private LocalDateTime startdatetime;
    private LocalDateTime enddatetime;

    public ShowHistoryStartInput(String start, String end){
        this.startdate = start;
        this.enddate = end;
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        this.startdatetime = LocalDateTime.parse(start, format);
        this.enddatetime = LocalDateTime.parse(end,format);
    }
    //getters here could be removed if we want to make code less and easy
    public String getStartdate(){return this.startdate;}
    public String getEnddate(){return this.enddate;}

    public LocalDateTime getStartdatetime(){return this.startdatetime;}
    public LocalDateTime getEnddatetime(){return this.enddatetime;}
    //we might need setters
}
