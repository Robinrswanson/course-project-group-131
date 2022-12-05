package show_history_use_case;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

public interface ShowHistoryDsGateway {
    //these two methods are to check if the dates that user enters are valid
    boolean StartDateValid(LocalDateTime startdate);
    boolean EndDateValid(LocalDateTime enddate);


    //To read from the history file and get the start date and end date of the whole history in the file
    public List<String[]> readfile(ShowHistoryStartInput startinput) throws IOException;

}
